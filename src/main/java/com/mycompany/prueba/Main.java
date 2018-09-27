/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prueba;

import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import java.awt.image.BufferedImage;
import java.util.Date;
/**
 *
 * @author frank
 */
public class Main {

    public static void main(String[] args) {
        
        staticFiles.location("publico");
        
         get("/saludos/:username", (request, response) -> {
             
             String nombre=request.params("username");
             
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("mensaje", "Hola Mundo!");
            attributes.put("usuario",nombre);
            attributes.put("fecha",new Date ().toString());
            
            return new ModelAndView(attributes, "pagina.ftl");
        }, new FreeMarkerEngine());

        get("/hello", (req, res) -> "Hello World");

        get("/hola/:name", (request, response) -> {
            return "Hola: " + request.params(":name");
        });
        path("/tep", () -> {

            path("/estudiantes", () -> {
                get("/ver", (request, response) -> {
                    return "Ver estudiantes" ;
                });
                get("/listar", (request, response) -> {
                    return "Listar Esetudiantes" ;
                });

            });

        });
    }
}
