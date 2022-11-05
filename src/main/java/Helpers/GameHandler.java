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
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author akile
 */
public class GameHandler {

    public static GameHandler gameHandlerInstance = new GameHandler();

    private DrinQuizContext _context;
    private Game game;
    private Player actualPlayer;
    private Question actualQuestion;
    private String[] answers;

    public GameHandler() {
        _context = new DrinQuizContext();
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void createPlayer(String playerName) {
        actualPlayer = new Player(0, game.getID(), playerName, 0, game.getCups(), game.getRefills());
        _context.Player.add(actualPlayer);
        setActualPlayer();
    }

    public void setActualPlayer() {
        List<Player> players = _context.Player.getAll();
        players = players.stream().filter(p -> p.getGameID() == game.getID()).toList();
        actualPlayer = players.get(players.size() - 1);
    }
    
    public int getPlayersCups(){
        return actualPlayer.getCupsLeft();
    }

    public void getNewQuestion() throws Exception {
        Question question;
        Random rnd = new Random();
        List<Question> questions = getFilteredQuestions();

        if (questions.isEmpty()) {
            throw new Exception("Out of questions");
        }
        question = questions.get(rnd.nextInt(questions.size()));

        actualQuestion = question;
        
        answers = new String[convertSeparatedStringToStringArray(actualQuestion.getAnswers()).length];
        for(int i = 0; i<answers.length; ++i)
            answers[i] = "0";
    }

    public Question getQuestion() {
        return actualQuestion;
    }
    
    public String[] getQuestionAnswers(){
        String[] answers = convertSeparatedStringToStringArray(actualQuestion.getAnswers());
        return answers;
    }
    private List<Question> getFilteredQuestions() {
        List<Question> questions = _context.Question.getAll();
        String[] sources = ConverterHelper.convertSeparatedStringToStringArray(game.getSources());
        String[] categories = ConverterHelper.convertSeparatedStringToStringArray(game.getCategories());

        questions = questions.stream().filter(
                q -> (Arrays.stream(sources).anyMatch(q.getSource()::contains))
                && (Arrays.stream(categories).anyMatch(q.getCategory()::contains))
                && (!isQuestionUsed(q))
        ).toList();
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
    
    
    public String[] getPickedAnswers() { return answers; }
    public void setPickedAnswers(String[] answers)
    {
        this.answers=answers;
        //ESEMÉNYKEZELŐ IDE, AMIRE A HOSZT FELíRATKOZIK, HOGY FRISSíTŐDJÖN A UI-JA
    }

    public void answerQuestion() {
        //Ki kell dolgozni mi történik, ha a kvízt megválaszolták
        int score = countScore(answers);
        String answersBlock = ConverterHelper.convertStringArrayToSeparatedString(answers);

        addQuestionToQuestionHistory(answersBlock);
        addScoreToPlayer(score);
    }

    //answers alapján pontozási rendszert kell kidolgozni
    private int countScore(String[] answers) {
        int score = 10;
        return score;
    }

    private void addQuestionToQuestionHistory(String answersBlock) {
        QuestionHistory questionHistory
                = new QuestionHistory(0, game.getID(), actualPlayer.getID(), actualQuestion.getID(), answersBlock);
        _context.QuestionHistory.add(questionHistory);
    }

    private void addScoreToPlayer(int score) {
        actualPlayer.setScore(actualPlayer.getScore() + score);
        _context.Player.update(actualPlayer);
    }
}
