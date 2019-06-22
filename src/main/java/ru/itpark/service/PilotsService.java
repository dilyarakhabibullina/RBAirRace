package ru.itpark.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itpark.domain.Pilot;
import ru.itpark.repository.PilotsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PilotsService {
    private final PilotsRepository repository;

    public List<Pilot> findAll() {
        return repository.findAll();
    }

    public Pilot findById(int id) {
        return repository.findById(id);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void save(Pilot pilot) {
        repository.save(pilot);
    }

}
