package best.team.petprojectsquad.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "report_dog")
@Getter
@Setter
@NoArgsConstructor
public class ReportDog extends Report{

    @ManyToOne
    @JoinColumn(name = "user_dog")
    private UserDog userDog;


}
