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
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "user_need_help")
    private boolean userNeedHelp =  false;
    @JsonIgnore
    @Column(name = "status")
    private String status = "On probation";

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

    //todo: нужен ли unique в chatId в таблицах userDog и userCat и оформить toString красивенько как и init.sql, переносить значения кошки или собкаи в бд после создания userCat и userDog
    /**
     * @return этот toString используется в сервисе:
     * @link VolunteerFunctionalControllerService
     */
    @Override
    public String toString() {
        return "UserCat{" +
               "id=" + id +
               ", chatId=" + chatId +
               ", dog id=" + cat.getId() +
               ", dogs name=" + cat.getName() +
               ", dogs breed=" + cat.getBreed() +
               ", dog description=" + cat.getDescription() +
               ", phoneNumber='" + phoneNumber + '\'' +
               ", trialPeriod=" + trialPeriod +
               ", user id =" + user.getId() +
               ", user name=" + user.getName() +
               ", user chat id=" + user.getChatId() +
               ", userNeedHelp=" + userNeedHelp +
               ", status='" + status + '\'' +
               '}';
    }
}