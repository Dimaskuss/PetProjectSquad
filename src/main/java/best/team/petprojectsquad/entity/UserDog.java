package best.team.petprojectsquad.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.pl.NIP;

import java.util.List;

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

    @OneToMany(mappedBy = "id")
    private List<User> user;

    @OneToOne
    @JoinColumn(name = "dog_id")
    private Dog dog;

    @Column(name = "phone")
    private int phoneNumber;

    public UserDog(long chatId) {
        this.chatId = chatId;
    }

    public UserDog(long id, long chatId, int phoneNumber) {
        this.id = id;
        this.chatId = chatId;
        this.phoneNumber = phoneNumber;
    }
}
