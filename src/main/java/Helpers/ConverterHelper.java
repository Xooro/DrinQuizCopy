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

    public static String[] convertSeparatedStringToStringArray(String separatedBlock) {
        if (!separatedBlock.contains(";;SEP;;")) {
            return new String[]{separatedBlock};
        }
        String[] separatedArray = separatedBlock.split(";;SEP;;");

        return separatedArray;
    }

    public static String convertStringArrayToSeparatedString(String[] separatedArray) {
        String separatedBlock = separatedArray[0];

        for (int i = 1; i < separatedArray.length; ++i) {
            separatedBlock += ";;SEP;;";
            separatedBlock += separatedArray[i];
        }

        return separatedBlock;
    }
}
