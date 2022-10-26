/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectdrinquiz.WebHandlers.Base;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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
      URL url = new URL(webURL);
      Scanner sc = new Scanner(url.openStream());
      StringBuffer sb = new StringBuffer();
      while(sc.hasNext()) {
         sb.append(sc.next());
      }

//      String result = sb.toString();
//      byte[] germanBytes = result.getBytes("UTF-8");
//      result = new String(germanBytes, "ISO-8859-2");

      byte[] germanBytes = sb.toString().getBytes("ISO8859_2");
      String result = new String(germanBytes, "UTF-8");
      
      PrintWriter out = new PrintWriter("filename.txt");
      out.println(result);
      
//      InputStreamReader isr = new InputStreamReader(url.openStream());
//        String encoding = isr.getEncoding();
//        System.out.println(encoding);
      
      return result;
    } 
    
    protected abstract List<String> convertWebPageStringToList(String webResult);
    
    public List<String> getDataFromWebpage(String webURL) 
            throws IOException
    {
        return convertWebPageStringToList(webpageToString(webURL));
    }
    
}
