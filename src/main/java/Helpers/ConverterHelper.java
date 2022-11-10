/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

/**
 *
 * @author akile
 */

//;;SEP;; elválasztást biztosítja
public class ConverterHelper {
    public static String SEPARATOR = ";;SEP;;";
    public static String[] convertSeparatedStringToStringArray(String separatedBlock) {
        if (!separatedBlock.contains(SEPARATOR)) {
            return new String[]{separatedBlock};
        }
        String[] separatedArray = separatedBlock.split(SEPARATOR);

        return separatedArray;
    }

    public static String convertStringArrayToSeparatedString(String[] separatedArray) {
        String separatedBlock = separatedArray[0];

        for (int i = 1; i < separatedArray.length; ++i) {
            separatedBlock += SEPARATOR;
            separatedBlock += separatedArray[i];
        }

        return separatedBlock;
    }
}
