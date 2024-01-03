package com.together.Modoo.repository;

import com.together.Modoo.model.Reply;
import com.together.Modoo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findAllByUser(User user);
}
