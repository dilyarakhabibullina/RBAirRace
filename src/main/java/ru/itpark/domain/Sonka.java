package ru.itpark.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sonka extends Pilot {
    private int id =1;
    private int pilotes_id;
    private String memberName ;
    private int rolesId;
    private int id1;
    private String role;
    private Date timeInTeam;
}
