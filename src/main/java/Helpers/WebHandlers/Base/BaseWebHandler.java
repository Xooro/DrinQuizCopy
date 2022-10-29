/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers.WebHandlers.Base;

import Models.Enums.Categories;
import Models.Enums.Sources;
import Models.Question;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author kkris
 */

public abstract class BaseWebHandler {

    protected Sources source;
    protected String encoding;
    protected String separator = ";;SEP;;";

    public BaseWebHandler(Sources source, String encoding) {
        this.source = source;
        this.encoding = encoding;
    }

    protected String[] webpageToStringArray(String url)
            throws MalformedURLException, IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        new URL(url).openStream(), encoding));
        StringBuffer sb = new StringBuffer();
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            sb.append(inputLine);
        }
        in.close();

        String result = new String(sb.toString().getBytes(), "UTF-8");

        String[] htmlDataSeparated = result.split("<br>");
        
        return htmlDataSeparated;
        
        //Into file for encode checking
//        PrintWriter out = new PrintWriter("EncodeCheck.txt");
//        out.println(result);
        //Tells the page encoding (buggy btw)
//      InputStreamReader isr = new InputStreamReader(url.openStream());
//        String encoding = isr.getEncoding();
//        System.out.println(encoding);
        
    }

    protected abstract List<Question> convertWebPageStringArrayToQuestionList(String[] htmlDataString, Categories category);

    
    public List<Question> getDataFromWebpage(String url, Categories category)
            throws IOException {
        return convertWebPageStringArrayToQuestionList(webpageToStringArray(url), category);
    }

}
