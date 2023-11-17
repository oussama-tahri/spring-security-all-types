package com.example.mvctest.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Patient {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 3, max = 10)
    private String name;
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datNaissance;
    private boolean malade;
    private int score;
}
