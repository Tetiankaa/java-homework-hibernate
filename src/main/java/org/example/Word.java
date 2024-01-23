package org.example;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "word")
@Data
public class Word {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;

    @Column(name = "value")
    private String value;
}
