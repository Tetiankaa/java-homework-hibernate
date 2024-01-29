package org.example;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@ToString
@Getter
@Setter
@Table(name = "cars")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "model")
    String model;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    Type type;

    @Column(name = "power")
    int power;

    @Column(name = "price")
    double price;

    @Column(name = "year")
    int year;
}
