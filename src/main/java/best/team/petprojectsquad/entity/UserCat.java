package best.team.petprojectsquad.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_cat")
@Data
@NoArgsConstructor
public class UserCat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "chat_id", nullable = false, unique = true)
    private long chatId;

    @Column(name = "phone")
    private int phoneNumber;

    @Column(name = "bot_state")
    private String botState;

    public UserCat(long chatId) {
        this.chatId = chatId;
    }
}
