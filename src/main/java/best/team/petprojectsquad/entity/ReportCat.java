package best.team.petprojectsquad.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.time.LocalDate;

@Entity
@Table(name = "report_cat")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ReportCat {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "report")
    private String report;
    @Column(name = "report_date")
    private LocalDate dateReport;
    @Column(name = "photo_id")
    private String photoId;
    @Column(name = "report_accepted")
    private boolean reportAccepted = false;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_cat_id")
    private UserCat userCat;

    public ReportCat(String report, LocalDate dateReport, String photoId) {
        this.report = report;
        this.dateReport = dateReport;
        this.photoId = photoId;
    }
}
