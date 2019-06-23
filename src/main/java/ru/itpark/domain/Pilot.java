package ru.itpark.domain;

import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pilot {
    private int id;
    private String pilotname;
    private Date birthdate;
    private int experience;
    private String aircraft;
}
