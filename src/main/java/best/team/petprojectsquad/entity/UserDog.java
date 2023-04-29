package best.team.petprojectsquad.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertFalse;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;

@Entity
@Table(name = "user_dog")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserDog {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderColumn
    private long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "chat_id", nullable = false, unique = true)
    private long chatId;
    @OneToOne
    @JsonIgnore // реализовать поиск по айди
    @JoinColumn(name = "dog_id")
    private Dog dog;
    @Column(name = "phone")
    private int phoneNumber;
    @Column(name = "trial_period")
    @JsonIgnore
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
