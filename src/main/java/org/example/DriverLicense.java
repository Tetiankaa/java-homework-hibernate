package org.example;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "driver_license")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class DriverLicense {
         @Id
         @GeneratedValue(strategy = GenerationType.IDENTITY)
         int id;

         @Column(name = "series")
         String series;
}
