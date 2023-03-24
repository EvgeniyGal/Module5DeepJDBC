package edu.goit.entity;

import lombok.Builder;
import lombok.ToString;

import java.time.LocalDate;

@Builder
@ToString
public class YOWorker {
    private String type;
    private String name;
    private LocalDate birthday;
}
