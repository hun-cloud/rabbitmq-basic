package com.example.hellomessagequeue.step2;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final WorkQueueProducer sender;

    public MessageController(WorkQueueProducer sender) {
        this.sender = sender;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam(value = "message") String message, @RequestParam(value = "duration") int duration) {
        sender.sendWorkQueue(message, duration);
        return "[#] Message send successfully! " + message;
    }

}
