package pl.MR.javagdy.webbappka.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double value;
    private GradesSubject subject;

    @CreationTimestamp
    private LocalDate timeCreated;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Student student;
}
