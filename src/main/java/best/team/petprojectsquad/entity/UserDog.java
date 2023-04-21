package best.team.petprojectsquad.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_dog")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderColumn
    private long id;

    @Column(name = "chat_id", nullable = false, unique = true)
    private long chatId;

    @ManyToOne
    @JoinColumn(name = "user_dog_id", nullable = true)
    private User user;

    @OneToOne(mappedBy = "UserDog")
    private Dog dog;

    @Column(name = "phone")
    private int phoneNumber;

    public UserDog(long chatId) {
        this.chatId = chatId;
    }
}
