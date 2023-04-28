package best.team.petprojectsquad.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Data
@Entity
@Table(name = "user_feedback")
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserFeedBack {

    @Id
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
    private boolean feedback;

    public UserFeedBack(String phoneNumber, long chatId, String name) {
        this.phoneNumber = phoneNumber;
        this.chatId = chatId;
        this.name = name;
    }
}
