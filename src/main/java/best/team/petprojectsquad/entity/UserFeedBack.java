package best.team.petprojectsquad.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user_feedback")
@NoArgsConstructor
@AllArgsConstructor
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

    public UserFeedBack(String phoneNumber, String name, long chatId,  boolean feedback) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.chatId = chatId;
        this.feedback = feedback;
    }
}
