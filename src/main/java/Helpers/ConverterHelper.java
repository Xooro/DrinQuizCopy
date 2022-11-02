/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

/**
 *
 * @author akile
 */
public class ConverterHelper {
    public static String[] convertSeparatedStringToStringArray(String stringBlock){
       String[] separatedItems = stringBlock.split(";;SEP;;");
       
       return separatedItems;
   } 
    
   public static String convertStringArrayToSeparatedString(String[] items){
       String separatedBlock = items[0];
       
       for(int i = 1; i < items.length; ++i){
           separatedBlock += ";;SEP;;";
           separatedBlock += items[i];
       }
       
       return separatedBlock;
   }
}
