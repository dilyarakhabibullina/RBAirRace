package ru.itpark.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pilot {
    private int id;
    private String pilotname;
    private int birthdate;
    private int experience;
    private String aircraft;
}
