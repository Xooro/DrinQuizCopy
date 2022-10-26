/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projectdrinquiz.WebHandlers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kkris
 */
public class WebHandler {
    public void importNapikvizToDatabase() throws IOException
    {
        Web_NapiKvizHandler napiKvizHandler = new Web_NapiKvizHandler("NapiKvíz","ISO8859_1");
        List<String> quizes = new ArrayList<>();
            
        List<String> TESTLIST = napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=tortenelem", "Történelem");
//        quizes.addAll(napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=tortenelem", "Történelem"));
//        quizes.addAll(napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=foldrajz", "Földrajz"));
    } 
}
