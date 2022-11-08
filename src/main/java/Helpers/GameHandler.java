/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import Data.DrinQuizContext;
import static Helpers.ConverterHelper.convertSeparatedStringToStringArray;
import Models.Game;
import Models.Player;
import Models.Question;
import Models.QuestionHistory;
import Views.JFrameHost;
import static Views.JFrameHost.jFrameHostInstance;
import Views.JFramePlayer;
import static Views.JFramePlayer.jFramePlayerInstance;
import com.k33ptoo.components.KGradientPanel;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author akile
 */
public class GameHandler {

    public static GameHandler gameHandlerInstance;

    private DrinQuizContext _context;
    private Game game;
    private Player actualPlayer;
    private Question actualQuestion;
    private String[] answersAsCups;
    private String actualAnswer;

    public GameHandler() {
        _context = new DrinQuizContext();
        
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void createPlayer(String playerName) {
        actualPlayer = new Player(0, game.getID(), playerName, 0, game.getCups(), game.getRefills(), false);
        _context.Player.add(actualPlayer);
        setActualPlayer();
    }

    public void setActualPlayer() {
        actualPlayer = getLastPlayerInList();
    }

    public Player getLastPlayerInList() {
        Player lastPlayer;
        List<Player> players = getGamePlayers();
        lastPlayer = players.get(players.size() - 1);

        return lastPlayer;
    }

    public List<Player> getGamePlayers(){
        List<Player> players = _context.Player.getAll();
        players = players.stream().filter(p -> p.getGameID() == game.getID()).toList();
        return players;
    }
    
    public Player getActualPlayer() {
        return actualPlayer;
    }
    
    public Game getGame() {
        return game;
    }
    
    public void setNewQuestion() throws Exception {
        Question question;
        Random rnd = new Random();
        List<Question> questions = getFilteredQuestions();

        if (questions.isEmpty()) {
            throw new Exception("Out of questions");
        }
        question = questions.get(rnd.nextInt(questions.size()));

        actualQuestion = question;

        answersAsCups = new String[convertSeparatedStringToStringArray(actualQuestion.getAnswers()).length];
        for (int i = 0; i < answersAsCups.length; ++i) {
            answersAsCups[i] = "0";
        }
        
        randomizeNewQuestion();
    }
    
    private List<Question> getFilteredQuestions() {
        List<Question> questions = _context.Question.getAll();
        String[] sources = ConverterHelper.convertSeparatedStringToStringArray(game.getSources());
        String[] categories = ConverterHelper.convertSeparatedStringToStringArray(game.getCategories());

//        questions = questions.stream().filter(
//                q -> (Arrays.stream(sources).anyMatch(q.getSource()::contains))
//                && (Arrays.stream(categories).anyMatch(q.getCategory()::contains))
//                && (!isQuestionUsed(q))
//        ).toList();
          questions = questions.parallelStream()
                  .filter(q -> (Arrays.stream(sources).anyMatch(q.getSource()::contains)))
                  .filter(q -> Arrays.stream(categories).anyMatch(q.getCategory()::contains))
                  .filter(q -> !isQuestionUsed(q))
                  .collect(Collectors.toList());
        return questions;
    }
    
    private Boolean isQuestionUsed(Question question) {
        List<QuestionHistory> usedQuestions = _context.QuestionHistory.getAll();
        for (QuestionHistory usedQuestion : usedQuestions) {
            if (usedQuestion.getQuestionID() == question.getID() && usedQuestion.getGameID() == game.getID()) {
                return true;
            }
        }
        return false;
    }

    public Question getActualQuestion() {
        return actualQuestion;
    }

    public String[] getQuestionAnswers() {
        String[] answers = convertSeparatedStringToStringArray(actualQuestion.getAnswers());
        return answers;
    }
    
    public String getActualAnswer() {
        return actualAnswer;
    }
    
    private void randomizeNewQuestion(){
        actualAnswer = getQuestionAnswers()[actualQuestion.getRightAnswerID()];
        String[] answersToRandomize = getQuestionAnswers();
        List<String> atrList = Arrays.asList(answersToRandomize);
        Collections.shuffle(atrList);
        atrList.toArray(answersToRandomize);
        String answerBlock = ConverterHelper.convertStringArrayToSeparatedString(answersToRandomize);
        actualQuestion.setAnswers(answerBlock);
    }

    public void refillCups() {
        if (actualPlayer.getRefillsLeft()>0)
        {
            actualPlayer.setCupsLeft(game.getCups());
            actualPlayer.setRefillsLeft(actualPlayer.getRefillsLeft()-1);
            _context.Player.update(actualPlayer);
        }  
    }

    public String[] getPickedAnswersAsCups() {
        return answersAsCups;
    }

    public void setPickedAnswers(String[] answers) {
        this.answersAsCups = answers;
        callFromPlayerToHost_AnswerCupsChanged();
    }

    public void answerQuestion() {
        String answersBlock = ConverterHelper.convertStringArrayToSeparatedString(answersAsCups);

        setNewCupsLeftAfterAnswer(); 
        addQuestionToQuestionHistory(answersBlock);     
        
        if (actualPlayer.getCupsLeft()==0)
        {        
            refillCups();
        }
        
        callFromHostToPlayer_RevealAnswer();
    }
    
    //answers alapján pontozási rendszert kell kidolgozni
    private void setNewCupsLeftAfterAnswer()
    {
        String[] answersArray = getQuestionAnswers();
        int newCupsLeft = actualPlayer.getCupsLeft();
        
        for(int i=0;i<answersAsCups.length;i++)
        {
            int cups = Integer.parseInt(answersAsCups[i]);
            if(answersArray[i].equals(actualAnswer))
            {
                addScoreToPlayer(cups);
            }
            else
            {
                newCupsLeft-=cups;
            }
        }
        actualPlayer.setCupsLeft(newCupsLeft);
        _context.Player.update(actualPlayer);
    }

    private void addScoreToPlayer(int correctCups) {
        int score = correctCups*10;
        actualPlayer.setScore(actualPlayer.getScore() + score);
    }
 
    private void addQuestionToQuestionHistory(String answersBlock) {
        QuestionHistory questionHistory
                = new QuestionHistory(0, game.getID(), actualPlayer.getID(), actualQuestion.getID(), answersBlock);
        _context.QuestionHistory.add(questionHistory);
    }

    public void endPlayerGame() {
        actualPlayer.setCupsLeft(0);
        actualPlayer.setRefillsLeft(0);
        _context.Player.update(actualPlayer);
        callFromHostToPlayer_PlayerGameEnded();
    }
    
    public void endGame() {
        game.setIsGameFinished(true);
        _context.Game.update(game);
        callFromHostToPlayer_GameEnded();
    }
    
    
    ///ESEMÉNYEK
    public void callFromPlayerToHost_PlayerGameStarted()
    {
        jFrameHostInstance.receive_PlayerGameStarted();
    }
    
    public void callFromPlayerToHost_AnswerCupsChanged()
    {
        jFrameHostInstance.receive_AnswerCupsChanged();
    }
    
    public void callFromPlayerToHost_HalfHelpUsed(List<Integer> indexesToRemove){
        jFrameHostInstance.receive_HalfHelpUsed(indexesToRemove);
        getActualPlayer().setIsHalfingUsed(true);
    }
    
    public void callFromPlayerToHost_CallHelpUsed()
    {
        jFrameHostInstance.receive_CallHelpUsed();
    }
    public void callFromPlayerToHost_GroupHelpUsed()
    {
        jFrameHostInstance.receive_GroupHelpUsed();
    }
    
    public void callFromHostToPlayer_RevealAnswer()
    {
        jFramePlayerInstance.receive_RevealAnswer();
    }
    
    public void callFromHostToPlayer_NextPlayerRound()
    {
        jFramePlayerInstance.receive_NextPlayerRound();
    }
    
    public void callFromHostToPlayer_PlayerGameEnded(){
        jFramePlayerInstance.receive_PlayerGameEnded();
    }
    
    public void callFromHostToPlayer_CreateNewPlayer(){
        jFramePlayerInstance.receive_CreateNewPlayer();
    }
    
    public void callFromHostToPlayer_GameEnded(){
        jFramePlayerInstance.receive_GameEnded();
    }
    
   
}
