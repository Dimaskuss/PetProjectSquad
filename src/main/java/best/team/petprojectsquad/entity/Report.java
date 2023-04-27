package best.team.petprojectsquad.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "report")
    private String report;

    @Column(name = "report_date")
    private LocalDate dateReport;

    @Column(name = "photo_path")
    private String photo_path;

    @Column(name = "report_accepted")
    private boolean reportAccepted;


}


