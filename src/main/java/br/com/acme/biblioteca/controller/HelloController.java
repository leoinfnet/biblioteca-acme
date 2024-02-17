package br.com.acme.biblioteca.controller;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public String sayHello(){
        System.out.println("Hello");
        return "hello";
        ///WEB-INF/jsp/hello.jsp
    }
    @GetMapping("/v2")
    public ModelAndView helloV2(ModelAndView model){
        model.setViewName("hellov2");
        return model;
    }
    @GetMapping("/v3")
    public ModelAndView helloV3(ModelAndView model){
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        model.addObject("firstName", firstName);
        model.addObject("lastName", lastName);
        model.setViewName("hellov3");
        return model;
    }


}
