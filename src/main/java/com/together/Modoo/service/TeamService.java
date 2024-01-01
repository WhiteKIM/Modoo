package com.together.Modoo.service;

import com.together.Modoo.model.Team;
import com.together.Modoo.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    public void save(Team team) {
        teamRepository.save(team);
    }

    public Team getTeam(Long id) {
        return teamRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void update(Team team) {
        Optional<Team> optionalTeam = teamRepository.findById(team.getId());
        if(optionalTeam.isEmpty())
            throw new RuntimeException();

        Team team1 = optionalTeam.get();
        team1.update(team);
    }

    public void delete(Long id) {
        return;
    }
}
