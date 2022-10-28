/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;
import Data.ModelServices.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author akile
 */
public class DrinQuizContext {    
    public QuestionModelService Question = new QuestionModelService();
    public QuestionHistoryModelService QuestionHistory = new QuestionHistoryModelService();
    public PlayerModelService Player = new PlayerModelService();
    public GameModelService Game = new GameModelService();
    
}

