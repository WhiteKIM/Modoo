package com.together.Modoo.service;

import com.together.Modoo.dto.request.member.RequestMember;
import com.together.Modoo.dto.response.member.ResponseMember;
import com.together.Modoo.model.Member;
import com.together.Modoo.model.Team;
import com.together.Modoo.model.User;
import com.together.Modoo.repository.MemberRepository;
import com.together.Modoo.repository.TeamRepository;
import com.together.Modoo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;
    private final UserRepository userRepository;

    public void save(RequestMember member) {
        User registerUser = userRepository.findById(member.userId()).orElseThrow();
        Team registerTeam = teamRepository.findById(member.teamId()).orElseThrow();
        memberRepository.save(Member.builder().user(registerUser).team(registerTeam).build());
    }

    public Member getMember(Long id) {
        return memberRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void update(Member member) {
        Optional<Member> optionalMember = memberRepository.findById(member.getId());
        if (optionalMember.isEmpty())
            throw new RuntimeException();

        Member member1 = optionalMember.get();
        member1.update(member);
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }

    public List<ResponseMember> findAllByTeamId(Long teamId) {
        List<Member> teamMember = memberRepository.findAllByTeam(teamRepository.findById(teamId).orElseThrow());
        return teamMember.stream().map(Member::toDto).toList();
    }
}
