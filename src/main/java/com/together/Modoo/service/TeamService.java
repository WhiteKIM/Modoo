package com.together.Modoo.service;

import com.together.Modoo.dto.request.team.RequestTeam;
import com.together.Modoo.dto.response.team.ResponseTeam;
import com.together.Modoo.model.Member;
import com.together.Modoo.model.Team;
import com.together.Modoo.model.User;
import com.together.Modoo.repository.MemberRepository;
import com.together.Modoo.repository.TeamRepository;
import com.together.Modoo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final UserRepository userRepository;
    private final MemberRepository memberRepository;

    public void save(RequestTeam requestTeam) {
        Team team = new Team(requestTeam);
        teamRepository.save(team);
    }

    public ResponseTeam getTeam(Long id) {
        return teamRepository.findById(id).orElseThrow(RuntimeException::new).toDto();
    }

    public void update(Long id, RequestTeam requestTeam) {
        Optional<Team> optionalTeam = teamRepository.findById(id);
        if (optionalTeam.isEmpty())
            throw new RuntimeException();

        Team team1 = optionalTeam.get();
        team1.update(requestTeam);
    }

    public void delete(Long id) {
        return;
    }

    public List<ResponseTeam> findTeamByUser(Long id) {
        User targetUser = userRepository.findById(id).orElseThrow(RuntimeException::new);
        List<Member> memberList = memberRepository.findAll();
        List<Team> teamList = new ArrayList<>();
        for (Member member : memberList) {
            if (targetUser.equals(member.getUser()))
                teamList.add(member.getTeam());
        }

        return teamList.stream().map(Team::toDto).toList();
    }
}
