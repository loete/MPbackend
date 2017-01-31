package at.fhj.swengs.service;

import at.fhj.swengs.model.Message;
import at.fhj.swengs.model.User;

import java.util.List;

/**
 * Created by loete on 31.01.2017.
 */
public interface MessageService {
    Message save(Message message);

    List<Message> findAll();

    List<Message> findByUser(User user);

    Message findByMessageID(Long messageId);
}
