package edu.goit.entity;

import lombok.Builder;
import lombok.ToString;

import java.time.LocalDate;


@Builder
@ToString
public class ProjectWithDuration {
    private int ID;
    private LocalDate startDate;
    private LocalDate finishDate;
    private int durMonths;
}
