package com.together.Modoo.service;

import com.together.Modoo.model.Reply;
import com.together.Modoo.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReplyProject {
    private final ReplyRepository replyRepository;

    public void save(Reply reply) {
        replyRepository.save(reply);
    }

    public Reply getReply(Long id) {
        return replyRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void update(Reply reply) {
        Optional<Reply> optionalReply = replyRepository.findById(reply.getId());
        if(optionalReply.isEmpty())
            throw new RuntimeException();

        Reply reply1 = optionalReply.get();
        reply1.update(reply);
    }

    public void delete() {

    }
}
