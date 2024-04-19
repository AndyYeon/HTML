package com.example.first_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/main")
    public String hello(Model model){
        model.addAttribute("username","수민");
        return "main";
    }

    @GetMapping("/bye")
    public String goodbye(){
        return "goodbye";
    }
    @GetMapping("/quote")
    public String randomQuotes(Model model){
        String [] quotes = {
                "행복은 습관이다. 그것을 몸에 지니라." +
                        "-하버드-"
                ,
                "고개 숙이지 마십시오 세상을 똑바로 정면으로" +
                        "바라보십시오. -헬렌 켈러-",
                "당신이 할 수 있다고 믿든 할 수 없다고 맏든" +
                        "믿는 대로 될 것이다. -헨리포드-" +
                        "작은 기회로부터 종종 위대한 업적이 시작된다." +
                        "데모스테네스"
        };
        int randInt = (int) (Math.random() * quotes.length);
        model.addAttribute("quotes",quotes[randInt]);

        return "quotes";
    }

}
