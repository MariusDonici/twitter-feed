package ro.uaic.twitter.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class TwitterFeed {

    @MessageMapping("/get")
    @SendTo("/topic/feed")
    public String getWebsocketResponse() throws InterruptedException {

        Thread.sleep(1000);
        return "Hello " + LocalDateTime.now();
    }

}
