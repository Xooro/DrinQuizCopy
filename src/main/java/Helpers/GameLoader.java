/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import Data.DrinQuizContext;
import static Helpers.GameHandler.gameHandlerInstance;
import Models.Game;
import Models.Player;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author akile
 */

//Játék betöltését biztosító osztály
public class GameLoader {
 
    private DrinQuizContext _context;
    DatabaseHandler databaseHandler;
    private List<Game> games;
    
    public GameLoader(){
        _context = new DrinQuizContext();
        databaseHandler = new DatabaseHandler();
    }
    public DefaultListModel loadGamesToList(){
        games = _context.Game.getAll();
        DefaultListModel demoList = new DefaultListModel();
        Collections.reverse(games);
        for(Game game : games){          
            if(!game.getIsGameFinished())
             demoList.addElement(game.getGameName() + " (" + game.getCreationDate() +")");
            else demoList.addElement(game.getGameName() + " (" + game.getCreationDate() +") (Befejezve)" );
        }
        return demoList;
    }
    
    public void loadGameForPlay(int gameIndex){
        Player player = null;
        Game gameToLoad = games.get(gameIndex);
        gameHandlerInstance.setGame(gameToLoad);
        try {
            player = gameHandlerInstance.getLastPlayerInList();
        } catch (Exception e) {
        }
        if(!(player==null || (player.getCupsLeft()==0 && player.getRefillsLeft()==0)))
        {
            gameHandlerInstance.setActualPlayer();
        }   
    }
    
    public void deleteGame(int gameIndex){
        Game gameToDelete = games.get(gameIndex);
        databaseHandler.deleteGameInDatabase(gameToDelete);   
    }
    
    
}
