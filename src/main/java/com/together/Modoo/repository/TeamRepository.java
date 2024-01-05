package com.together.Modoo.repository;

import com.together.Modoo.model.Member;
import com.together.Modoo.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByMembersIn(Member member);
}
