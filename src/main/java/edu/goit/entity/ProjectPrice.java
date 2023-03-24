package edu.goit.entity;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class ProjectPrice {
    private int ID;
    private int price;
}
