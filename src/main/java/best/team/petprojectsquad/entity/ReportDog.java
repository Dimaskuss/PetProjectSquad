package best.team.petprojectsquad.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.time.LocalDate;

@Entity
@Table(name = "report_dog")
@Getter
@Setter
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ReportDog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "report")
    private String report;

    @Column(name = "report_date")
    private LocalDate dateReport;

    @Column(name = "photo_id")
    private String photoId;

    @Column(name = "report_accepted")
    private boolean reportAccepted;
    @ManyToOne
    @JoinColumn(name = "user_dog")
    private UserDog userDog;
}
