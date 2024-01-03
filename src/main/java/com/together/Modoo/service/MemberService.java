package com.together.Modoo.service;

import com.together.Modoo.dto.request.RequestMember;
import com.together.Modoo.dto.response.ResponseMember;
import com.together.Modoo.model.Member;
import com.together.Modoo.model.Team;
import com.together.Modoo.model.User;
import com.together.Modoo.repository.MemberRepository;
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
    private final TeamService teamService;
    private final UserService userService;

    public void save(RequestMember member) {
        User registerUser = userService.getUser(member.getUserId());
        Team registerTeam = teamService.getTeam(member.getTeamId());
        memberRepository.save(Member.builder().user(registerUser).team(registerTeam).build());
    }

    public Member getMember(Long id) {
        return memberRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void update(Member member) {
        Optional<Member> optionalMember = memberRepository.findById(member.getId());
        if(optionalMember.isEmpty())
            throw new RuntimeException();

        Member member1 = optionalMember.get();
        member1.update(member);
    }

    public void delete(Long id){
        return;
    }

    public List<ResponseMember> findAllByTeamId(Long teamId) {
        List<Member> teamMember = memberRepository.findAllByTeam(teamService.getTeam(teamId));
        return teamMember.stream().map(Member::toDto).toList();
    }
}
