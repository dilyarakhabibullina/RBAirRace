package ru.itpark.repository;


import jdk.jfr.Registered;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itpark.domain.Team;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TeamRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<Team> findAll() {
        return jdbcTemplate.query("SELECT id, pilotes_id, member_name, roles_id, time_in_team FROM team",
                (rs, i) -> new Team(
                        rs.getInt("id"),
                        rs.getInt("pilotes_id"),
                        rs.getString("member_name"),
                        rs.getInt("roles_id"),
                        rs.getDate("time_in_team")
                )
        );
    }

    public Team findByPilotesId(int id) {
        return jdbcTemplate.queryForObject("SELECT id, pilotes_id, member_name, roles_id, time_in_team FROM team WHERE pilotes_id = ?",
                new Object[] {id},
                (rs, i) -> new Team(rs.getInt("id"),
                        rs.getInt("pilotes_id"),
                        rs.getString("member_name"),
                        rs.getInt("roles_id"),
                        rs.getDate("time_in_team")
                )
                );
    }
}



