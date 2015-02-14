package com.lynas.controller;

import com.lynas.services.Greeting;
import com.lynas.services.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LynAs on 2/14/2015.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String home() {
        return "test";
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(3000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }


}
