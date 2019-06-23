package ru.itpark.repository;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.itpark.domain.Pilot;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PilotsRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<Pilot> findAll() {
        return jdbcTemplate.query("SELECT id, pilotname, birthdate, experience, aircraft FROM pilots",
                (rs, i) -> new Pilot(
                        rs.getInt("id"),
                        rs.getString("pilotname"),
                        rs.getDate("birthdate"),
                        rs.getInt("experience"),
                        rs.getString("aircraft")
                ));
    }

    public Pilot findById(int id) {
        return jdbcTemplate.queryForObject("SELECT id, pilotname, birthdate, experience, aircraft FROM pilots WHERE id = ?",
                new Object[]{id},
                (rs, i) -> new Pilot(
                        rs.getInt("id"),
                        rs.getString("pilotname"),
                        rs.getDate ("birthdate"),
                        rs.getInt("experience"),
                        rs.getString("aircraft")
                ));
    }

    public void removeById(int id) {
        jdbcTemplate.update("DELETE FROM pilots WHERE id = ?",
                id);
    }

    public void save(Pilot pilot) {
        if (pilot.getId() == 0) {
            jdbcTemplate.update("INSERT INTO pilots (id, pilotname, birthdate, experience, aircraft)  VALUES (?,?,?,?,?)",
                    pilot.getId(), pilot.getPilotname(), pilot.getBirthdate(), pilot.getExperience(), pilot.getAircraft());
        } else {
            jdbcTemplate.update("UPDATE pilots SET pilotname = ?, birthdate = ?, experience = ?, aircraft = ? WHERE id = ?", pilot.getId(), pilot.getPilotname(), pilot.getBirthdate(), pilot.getExperience(), pilot.getAircraft());

        }

    }
}

