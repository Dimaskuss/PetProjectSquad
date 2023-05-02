package best.team.petprojectsquad.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

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
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "cat_id")
    private Cat cat;
    @Column(name = "chat_id", nullable = false, unique = true)
    private long chatId;
    @Column(name = "phone")
    private String phoneNumber;
    @JsonIgnore
    @Column(name = "trial_period")
    private int trialPeriod = 30;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private User user;
    private boolean userNeedHelp;

    public UserCat(long chatId) {
        this.chatId = chatId;
    }

    public UserCat(User user) {
        this.user = user;
    }

    public UserCat(long id, Cat cat, long chatId, String phoneNumber) {
        this.id = id;
        this.cat = cat;
        this.chatId = chatId;
        this.phoneNumber = phoneNumber;
    }

    public UserCat(long chatId, String phoneNumber) {
        this.chatId = chatId;
        this.phoneNumber = phoneNumber;
    }
}