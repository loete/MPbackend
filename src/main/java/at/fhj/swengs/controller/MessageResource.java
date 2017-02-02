package at.fhj.swengs.controller;

import at.fhj.swengs.model.Message;
import at.fhj.swengs.model.MessageRepository;
import at.fhj.swengs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by loete on 31.01.2017.
 */
@RestController
@RequestMapping("/rest")
public class MessageResource {

    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping(value = "/message/add", method= RequestMethod.POST)
    public Message addMessage(@RequestBody Message message){
        return messageRepository.save(message);
    }

    @RequestMapping(value = "/message/user", method= RequestMethod.POST)
    public List<Message> getMessagesByUser(@RequestBody User user){
        return messageRepository.findByUser(user);
    }

    @RequestMapping(value = "/message/messageId", method= RequestMethod.POST)
    public Message getMessageByMessageId(@RequestBody Long messageId){
        return messageRepository.findByMessageID(messageId);
    }

    @RequestMapping(value = "/message/update", method= RequestMethod.POST)
    public void updateMessage(@RequestBody Message message){
        Message currentMessage = messageRepository.findByMessageID(message.getMessageID());
        currentMessage.setLikes(message.getLikes());
        messageRepository.save(currentMessage);
    }

    @RequestMapping(value = "/message/edit", method= RequestMethod.POST)
    public void editMessage(@RequestBody Message message){
        Message currentMessage = messageRepository.findByMessageID(message.getMessageID());
        currentMessage.setMessageContent(message.getMessageContent());
        currentMessage.setMessageDate(message.getMessageDate());
        currentMessage.setMessageTitle(message.getMessageTitle());
        currentMessage.setUser(message.getUser());
        messageRepository.save(currentMessage);
    }


    @RequestMapping(value= "/message/delete", method= RequestMethod.POST)
    public void deleteMessage(@RequestBody Message message) {
        messageRepository.delete(message);
    }

}
