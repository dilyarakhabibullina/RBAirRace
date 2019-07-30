package ru.itpark.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.itpark.domain.*;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class TeamRepository {
    private final JdbcTemplate jdbcTemplate;
    public Pilot pilot = new Pilot();


    public List<TeamMS> findMSTeam() {

        return jdbcTemplate.query("SELECT id, pilotes_id, member_name, ROLES_ID, ID1, TEAM_ROLE, time_in_team FROM  team, roles WHERE pilotes_id=1 AND team.ROLES_ID =ROLES.ID1 "
                ,
                (rs, i) -> new TeamMS(
                        rs.getInt("id"),
                        rs.getInt("pilotes_id"),
                        rs.getString("member_name"),
                        rs.getInt("roles_id"),
                        rs.getInt("id1"),
                        rs.getString("team_role"),
                        rs.getDate("time_in_team")
                )
        );
    }

    public List<TeamYM> findYMTeam() {

        return jdbcTemplate.query("SELECT id, pilotes_id, member_name, ROLES_ID, ID1, TEAM_ROLE, time_in_team FROM  team, roles WHERE pilotes_id=2 AND team.ROLES_ID =ROLES.ID1 ",
                (rs, i) -> new TeamYM(
                        rs.getInt("id"),
                        rs.getInt("pilotes_id"),
                        rs.getString("member_name"),
                        rs.getInt("roles_id"),
                        rs.getInt("id1"),
                        rs.getString("team_role"),
                        rs.getDate("time_in_team")
                )
        );
    }

    public List<TeamPL> findPLTeam() {

        return jdbcTemplate.query("SELECT id, pilotes_id, member_name, ROLES_ID, ID1, TEAM_ROLE, time_in_team FROM  team, roles WHERE pilotes_id=3 AND team.ROLES_ID =ROLES.ID1 "
                ,
                (rs, i) -> new TeamPL(
                        rs.getInt("id"),
                        rs.getInt("pilotes_id"),
                        rs.getString("member_name"),
                        rs.getInt("roles_id"),
                        rs.getInt("id1"),
                        rs.getString("team_role"),
                        rs.getDate("time_in_team")
                )
        );
    }

    public List<TeamNI> findNITeam() {

        return jdbcTemplate.query("SELECT id, pilotes_id, member_name, ROLES_ID, ID1, TEAM_ROLE, time_in_team FROM  team, roles WHERE pilotes_id=4 AND team.ROLES_ID =ROLES.ID1 ",
                (rs, i) -> new TeamNI(
                        rs.getInt("id"),
                        rs.getInt("pilotes_id"),
                        rs.getString("member_name"),
                        rs.getInt("roles_id"),
                        rs.getInt("id1"),
                        rs.getString("team_role"),
                        rs.getDate("time_in_team")
                )
        );
    }





    public Team findByPilotesId(int id) {
        return jdbcTemplate.queryForObject("SELECT id, pilotes_id, member_name, roles_id, time_in_team FROM team WHERE pilotes_id = ?",
                new Object[]{id},
                (rs, i) -> new Team(rs.getInt("id"),
                        rs.getInt("pilotes_id"),
                        rs.getString("member_name"),
                        rs.getInt("roles_id"),
                        rs.getDate("time_in_team")
                )
        );
    }

}



