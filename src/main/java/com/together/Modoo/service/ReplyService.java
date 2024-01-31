package com.together.Modoo.service;

import com.together.Modoo.dto.request.reply.RequestReply;
import com.together.Modoo.dto.response.reply.ResponseReply;
import com.together.Modoo.model.Reply;
import com.together.Modoo.model.User;
import com.together.Modoo.repository.ReplyRepository;
import com.together.Modoo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final UserRepository userRepository;

    public void save(RequestReply reply) {
        if (reply.parentId() == null) {
            saveRootReply(reply);
        } else {
            saveChildReply(reply);
        }
    }

    public ResponseReply getReply(Long id) {
        return replyRepository.findById(id).orElseThrow(RuntimeException::new).toDto();
    }

    public List<ResponseReply> getUserReplies(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(RuntimeException::new);
        List<Reply> replyList = replyRepository.findAllByUser(user);
        return replyList.stream().map(Reply::toDto).toList();
    }

    public void update(Reply reply) {
        Optional<Reply> optionalReply = replyRepository.findById(reply.getId());
        if (optionalReply.isEmpty())
            throw new RuntimeException();

        Reply reply1 = optionalReply.get();
        reply1.update(reply);
    }

    public void delete(Long id) {
        replyRepository.deleteById(id);
    }

    private void saveRootReply(RequestReply requestReply) {
        User user = userRepository.findById(requestReply.userId()).orElseThrow(RuntimeException::new);
        Reply reply = new Reply(requestReply);
        reply.setUser(user);
        replyRepository.save(reply);
    }

    private void saveChildReply(RequestReply requestReply) {
        User user = userRepository.findById(requestReply.userId()).orElseThrow(RuntimeException::new);
        Reply parent = replyRepository.findById(requestReply.parentId()).orElseThrow(RuntimeException::new);
        Reply reply = new Reply(requestReply);
        reply.setUser(user);
        reply.setParent(parent);
        parent.getReplyList().add(replyRepository.save(reply));
    }
}
