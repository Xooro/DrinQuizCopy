/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.projectdrinquiz;

import com.mycompany.projectdrinquiz.WebHandlers.Web_NapiKvizHandler;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author kkris
 */
public class ProjectDrinQuiz {

    public static void main(String[] args) throws IOException {
        Web_NapiKvizHandler napiKvizHandler = new Web_NapiKvizHandler();
        //List<String> test = napiKvizHandler.getDataFromWebpage("http://napikviz.tutioldal.hu/index.php?kvizkerdesek=tortenelem");
    }
}
