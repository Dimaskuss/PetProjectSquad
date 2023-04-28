package best.team.petprojectsquad.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Data
@Entity
@Table(name = "user_table")
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderColumn
    private long id;
    @Column(name = "chat_id")
    private long chatId;
    @Column(name = "name")
    private String name;
    @OneToOne
    @JoinColumn(name = "user_cat_id", nullable = true)
    private UserCat catList;
    @OneToOne
    @JoinColumn(name = "user_dog_id", nullable = true)
    private UserDog dogList;

    public User(long chatId) {
        this.chatId = chatId;
    }

    public User(long chatId, String name) {
        this.chatId = chatId;
        this.name = name;
    }
}
