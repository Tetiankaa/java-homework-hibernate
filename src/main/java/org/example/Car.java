package org.example;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cars")
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String model;
    @Column
    @Enumerated(EnumType.STRING)
    private Type type;
    @Column
    private int power;
    @Column
    private double price;
    @Column
    private int year;
}
