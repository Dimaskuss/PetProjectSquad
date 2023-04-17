package best.team.petprojectsquad.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_dog")
@Data
@NoArgsConstructor
public class UserDog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderColumn
    private long id;

    @Column(name = "chat_id", nullable = false, unique = true)
    private long chatId;

    @Column(name = "phone")
    private int phoneNumber;

    @Column(name = "bot_state")
    private String botState;

    public UserDog(long chatId) {
        this.chatId = chatId;
    }
}
