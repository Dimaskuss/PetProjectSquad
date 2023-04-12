package best.team.petprojectsquad.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "chat_id", nullable = false, unique = true)
    private long chatId;

    @Column(name = "phone")
    private int phoneNumber;

    @Column(name = "bot_state")
    private String botState;

    public User(long chatId) {
        this.chatId = chatId;
    }
}
