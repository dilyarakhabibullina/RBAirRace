package ru.itpark.service;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itpark.domain.Pilot;
import ru.itpark.domain.Team;
import ru.itpark.repository.TeamRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    public final TeamRepository repository;
    public List<Team> findAll() {
        return repository.findAll();
    }

    public Team findByPilotesId (int pilotes_id){
        return repository.findByPilotesId(pilotes_id);
    }
}
