package ru.itpark.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamYM {
    private int id;
    private int pilotes_id;
    private String memberName;
    private int rolesId;
    private Date timeInTeam;
}
