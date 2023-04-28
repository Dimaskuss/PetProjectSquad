package best.team.petprojectsquad.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;

@Entity
@Table(name = "user_cat")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class UserCat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderColumn
    private long id;
    @OneToMany(mappedBy = "id")
    private List<User> user;
    @OneToOne
    @JoinColumn(name = "cat_id")
    private Cat cat;
    @Column(name = "chat_id", nullable = false, unique = true)
    private long chatId;
    @Column(name = "phone")
    private int phoneNumber;
    public UserCat(long chatId) {
        this.chatId = chatId;
    }
}
