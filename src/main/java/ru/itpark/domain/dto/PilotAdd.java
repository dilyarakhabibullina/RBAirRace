package ru.itpark.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PilotAdd {
    private String pilotname;
    private Date birthdate;
    private int experience;
    private String aircraft;
}
