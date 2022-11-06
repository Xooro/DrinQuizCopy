/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import Data.DrinQuizContext;
import Models.Game;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListModel;

/**
 *
 * @author akile
 */
public class GameLoader {
 
    private DrinQuizContext _context;
    
    public GameLoader(){
        _context = new DrinQuizContext();
    }
    public DefaultListModel loadGamesToList(){
        List<Game> games = _context.Game.getAll();
        DefaultListModel demoList = new DefaultListModel();
        Collections.reverse(games);
        for(Game game : games){
            
             demoList.addElement(game.getGameName() + " (" + game.getCreationDate() +")");

        }
        return demoList;
    }
    
    public void loadGameForPlay(){
        
    }
}
