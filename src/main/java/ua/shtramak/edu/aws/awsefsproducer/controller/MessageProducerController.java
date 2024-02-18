package ua.shtramak.edu.aws.awsefsproducer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.shtramak.edu.aws.awsefsproducer.service.SaveMessageService;

@RestController
@RequestMapping("/messages")
public class MessageProducerController {

    private final SaveMessageService service;

    public MessageProducerController(SaveMessageService service) {
        this.service = service;
    }

    @PostMapping
    public void saveMessage(@RequestBody String message) {
        service.saveMessageToFile(message);
    }
    
    @GetMapping
    public ResponseEntity<String> getMessages(){
        return ResponseEntity.ok(service.getMessages());
    }
}
