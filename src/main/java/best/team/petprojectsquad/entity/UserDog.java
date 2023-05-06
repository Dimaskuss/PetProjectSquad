package best.team.petprojectsquad.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
//TODO: написать тесты! убрать лишние конки из БД
@Entity
@Table(name = "user_dog")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserDog {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderColumn
    private long id;
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
    private int trialPeriod;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
    @Column(name = "user_need_help")
    private boolean userNeedHelp = false;
    @JsonIgnore
    @Column(name = "status")
    private String status = "On probation";

    public UserDog(long chatId) {
        this.chatId = chatId;
    }

    public UserDog(User user) {
        this.user = user;
    }

    public UserDog(long id, long chatId, String phoneNumber) {
        this.id = id;
        this.chatId = chatId;
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return этот toString используется в сервисе:
     * @link VolunteerFunctionalControllerService
     */
    @Override
    public String toString() {
        return "UserDog{" +
               "id=" + id +
               ", chatId=" + chatId +
               ", dog id=" + dog.getId() +
               ", dogs name=" + dog.getName() +
               ", dogs breed=" + dog.getBreed() +
               ", dog description=" + dog.getDescription() +
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