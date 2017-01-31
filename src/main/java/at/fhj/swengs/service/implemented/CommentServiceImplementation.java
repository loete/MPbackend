/**package at.fhj.swengs.service.implemented;

import at.fhj.swengs.model.Comment;
import at.fhj.swengs.model.CommentRepository;
import at.fhj.swengs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImplementation implements CommentService {

    @Autowired
    private CommentRepository commentRepo;

    @Override
    public Comment save(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public List<Comment> findByMessageId(Long messageId) {
        return commentRepo.findByMessageId(messageId);
    }

    @Override
    public Comment findOne(Long commentId) {
        return commentRepo.findOne(commentId);
    }
}

*/