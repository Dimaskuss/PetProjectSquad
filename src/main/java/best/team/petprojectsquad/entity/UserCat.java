package best.team.petprojectsquad.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;

@Entity
@Table(name = "user_cat")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserCat {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderColumn
    private long id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "cat_id")
    private Cat cat;
    @Column(name = "chat_id", nullable = false, unique = true)
    private long chatId;
    @Column(name = "phone")
    private int phoneNumber;
    @JsonIgnore
    @Column(name = "trial_period")
    private int trialPeriod = 30;

    public UserCat(long chatId) {
        this.chatId = chatId;
    }

    public UserCat(long id, User user, Cat cat, long chatId, int phoneNumber) {
        this.id = id;
        this.user = user;
        this.cat = cat;
        this.chatId = chatId;
        this.phoneNumber = phoneNumber;
    }
}
