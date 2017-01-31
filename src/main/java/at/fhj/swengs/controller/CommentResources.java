/** package at.fhj.swengs.controller;

import at.fhj.swengs.model.Comment;
import at.fhj.swengs.model.Message;
import at.fhj.swengs.service.CommentService;
import at.fhj.swengs.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class CommentResources {
    @Autowired
    private MessageService messageService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comment/add", method = RequestMethod.POST)
    public void addComment(@RequestBody Comment comment){
        Message message = messageService.findByMessageID(comment.getMessageID());
        List<Comment> commentList = message.getCommentList();
        comment.setMessage(message);
        commentService.save(comment);
    }
}
*/
