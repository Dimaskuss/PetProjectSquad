package best.team.petprojectsquad.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

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
    @JoinColumn(name = "user_id")
    private long userId;
    @Column(name = "chat_id", nullable = false, unique = true)
    private long chatId;
    @OneToOne
    @JsonIgnore // реализовать поиск по айди
    @JoinColumn(name = "dog_id")
    private Dog dog;
    @Column(name = "phone")
    private String phoneNumber;
    @Column(name = "trial_period")
    @JsonIgnore
    private int trialPeriod = 30;
    @JsonIgnore
    @ManyToOne
    private User user;
    private UserNeedHelp userNeedHelp;

    public UserDog(long chatId) {
        this.chatId = chatId;
    }

    public UserDog(long id, long chatId, String phoneNumber) {
        this.id = id;
        this.chatId = chatId;
        this.phoneNumber = phoneNumber;
    }
}