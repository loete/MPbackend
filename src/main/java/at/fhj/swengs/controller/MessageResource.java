package at.fhj.swengs.controller;

import at.fhj.swengs.model.Message;
import at.fhj.swengs.model.MessageRepository;
import at.fhj.swengs.model.User;
import at.fhj.swengs.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

/**
 * Created by loete on 31.01.2017.
 */
@RestController
@RequestMapping("/rest")
public class MessageResource {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/message/add", method= RequestMethod.POST)
    public Message addMessage(@RequestBody Message message){
        return messageService.save(message);
    }

    @RequestMapping(value = "/message/user", method= RequestMethod.POST)
    public List<Message> getMessagesByUser(@RequestBody User user){
        return messageService.findByUser(user);
    }

    @RequestMapping(value = "/message/messageId", method= RequestMethod.POST)
    public Message getMessageByMessageId(@RequestBody Long messageId){
        return messageService.findByMessageID(messageId);
    }

    @RequestMapping(value = "/message/update", method= RequestMethod.POST)
    public void updateMessage(@RequestBody Message message){
        Message currentMessage = messageService.findByMessageID(message.getMessageID());
        currentMessage.setLikes(message.getLikes());
        messageService.save(currentMessage);
    }

    @RequestMapping(value = "/message/edit", method= RequestMethod.POST)
    public void editMessage(@RequestBody Message message){
        Message currentMessage = messageService.findByMessageID(message.getMessageID());
        currentMessage.setMessageContent(message.getMessageContent());
        currentMessage.setMessageDate(message.getMessageDate());
        currentMessage.setMessageTitle(message.getMessageTitle());
        messageService.save(currentMessage);
    }

    @RequestMapping(value= "/message/delete/{messageID}", method= RequestMethod.POST)
    public void deleteMessage(@PathVariable("messageID") Long id) {
        messageRepository.delete(id);
    }

}
