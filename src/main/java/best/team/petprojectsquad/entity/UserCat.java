package best.team.petprojectsquad.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_cat")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderColumn
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_cat_id", nullable = true)
    private User user;
    @OneToOne(mappedBy = "UserCat")
    private Cat cat;
    @Column(name = "chat_id", nullable = false, unique = true)
    private long chatId;
    @Column(name = "phone")
    private int phoneNumber;

    public UserCat(long chatId) {
        this.chatId = chatId;
    }
}
