package best.team.petprojectsquad.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;

@Entity
@Table(name = "user_dog")
@Data
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserDog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderColumn
    private long id;
    @Column(name = "chat_id", nullable = false, unique = true)
    private long chatId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "dog_id")
    private Dog dog;
    @Column(name = "phone")
    private int phoneNumber;
    @Column(name = "trial_period")
    private int trialPeriod = 30;

    public UserDog(long chatId) {
        this.chatId = chatId;
    }

    public UserDog(long id, long chatId, int phoneNumber) {
        this.id = id;
        this.chatId = chatId;
        this.phoneNumber = phoneNumber;
    }
}
