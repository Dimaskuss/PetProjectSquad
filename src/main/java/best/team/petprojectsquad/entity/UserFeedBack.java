package best.team.petprojectsquad.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "user_feedback")
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserFeedBack {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderColumn
    private long id;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "chat_id")
    private long chatId;
    @Column(name = "name")
    private String name;
    @Column(name = "feedback")
    private boolean feedback = true;
    //Конструктор для заказа обратного звонка
    public UserFeedBack(String phoneNumber, long chatId, String name)  {
        this.phoneNumber = phoneNumber;
        this.chatId = chatId;
        this.name = name;
    }

    //конструктор для волонтера(отсутствует номер телефона)
    public UserFeedBack(long chatId, String name) {
        this.chatId = chatId;
        this.name = name;
    }
}
