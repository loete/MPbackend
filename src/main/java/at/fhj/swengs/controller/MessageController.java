package at.fhj.swengs.controller;

import at.fhj.swengs.model.Message;
import at.fhj.swengs.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by loete on 31.01.2017.
 */
@RestController
@RequestMapping(value="/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("/allMessages")
    public List<Message> getAllMessages() {
        return messageService.findAll();
    }
}
