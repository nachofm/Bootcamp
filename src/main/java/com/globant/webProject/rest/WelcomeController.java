package com.globant.webProject.rest;

import com.globant.webProject.model.Welcome;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/***
 * Como la clase va a ser un controlador se
 * incluye la anotacion @RestController
 * que retorna un objeto de dominio en lugar de una vista
 */
@RestController
public class WelcomeController {


    private static final String message1 = "Hola %s, ";
    private static final String message2 ="bienvenido a %s";

    /***
     * Uso @RequestMapping para indicar a que URI va
     * a responder el controlador */

    @RequestMapping(value="/bienvenida/{name}", method=GET)
    ///welcomeMethod es un metodo de la clase controlador que va a crear un objeto de Welcome
    public Welcome welcomeMethod(@PathVariable(value="name") String name, @RequestParam(value="company") String company){

        return new Welcome(String.format(message1, name),String.format(message2, company));
    }//localhost:8080/bienvenida/nacho?company=Globant


    /**
    @GetMapping(value= "/bienvenida/{name}")
    @ResponseBody
    public String welcomeMethod(@PathVariable(value="name") String name, @RequestParam(value= "company") String company){
        //return new Welcome(String.format(message,name, company));
        return "Hello " + name + " welcome to " + company;
    }//localhost:8080/bienvenida/nacho?company=Globant
     **/



    @RequestMapping(method=POST)
    @ResponseBody
    public String postMethod(@RequestBody String homework) {

        return homework;
    }
}
