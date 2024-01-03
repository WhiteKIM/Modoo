package com.together.Modoo.repository;

import com.together.Modoo.model.Member;
import com.together.Modoo.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findAllByTeam(Team team);
}
