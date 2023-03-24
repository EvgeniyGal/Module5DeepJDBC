package edu.goit.entity;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class MaxProjectClient {
    private int ID;
    private String name;
    private int projectCount;
}
