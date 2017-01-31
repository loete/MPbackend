package at.fhj.swengs.service.implemented;

import at.fhj.swengs.model.Message;
import at.fhj.swengs.model.MessageRepository;
import at.fhj.swengs.model.User;
import at.fhj.swengs.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by loete on 31.01.2017.
 */
@Service
public class MessageServiceImplementation implements MessageService {

    @Autowired
    private MessageRepository messageRepo;

    @Override
    public Message save(Message message){
        return messageRepo.save(message);
    }

    @Override
    public List<Message> findAll() {
        return messageRepo.findAll();
    }

    @Override
    public List<Message> findByUser(User user) {
        return messageRepo.findByUser(user);
    }

    @Override
    public Message findByMessageID(Long messageId){
        return messageRepo.findByMessageID(messageId);
    }
}
