/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectdrinquiz.WebHandlers.Base;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author kkris
 */
public abstract class WebHandler {
    protected String webpageToString(String webURL) 
            throws MalformedURLException, IOException
    {
      //Instantiating the URL class
      URL url = new URL(webURL);
      //Retrieving the contents of the specified page
      Scanner sc = new Scanner(url.openStream());
      //Instantiating the StringBuffer class to hold the result
      StringBuffer sb = new StringBuffer();
      while(sc.hasNext()) {
         sb.append(sc.next());
         //System.out.println(sc.next());
      }
      //Retrieving the String from the String Buffer object
      String result = sb.toString();
      //Removing the HTML tags
      //result = result.replaceAll("<[^>]*>", "");
      return result;
    } 
    
    protected abstract List<String> convertWebPageStringToList(String webResult);
    
    public List<String> getDataFromWebpage(String webURL) 
            throws IOException
    {
        return convertWebPageStringToList(webpageToString(webURL));
    }
    
}
