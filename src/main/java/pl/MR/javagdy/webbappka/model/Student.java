package pl.MR.javagdy.webbappka.model;

import lombok.*;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private boolean graduated;

    private Double homeDistance;

    private LocalDate birthDate;
    //birthDate jest nazwą kolumny w bazie. Czasem nazwa kolumny z podkreślnikami mozemy napotkac problemy.
    @Formula("(year(now())-year(birthDate))")
    // Integer, żeby wiek mógł w razie co być nullem, gdyby ktoś nie podał birthdate
    private Integer age;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Grade> gradeSet;

}
