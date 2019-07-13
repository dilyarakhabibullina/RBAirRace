package ru.itpark.service;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itpark.domain.*;
import ru.itpark.repository.TeamRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    public final TeamRepository repository;

    public List<TeamMS> findMSTeam() {
        return repository.findMSTeam();
    }

    public List<TeamYM> findYMTeam() {
        return repository.findYMTeam();
    }

    public List<TeamPL> findPLTeam() {
        return repository.findPLTeam();
    }

    public List<TeamNI> findNITeam() {
    return repository.findNITeam();}
}


