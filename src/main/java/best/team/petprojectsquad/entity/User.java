package best.team.petprojectsquad.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;


@Getter
@Setter
@EqualsAndHashCode
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
    @OneToMany
    @JoinColumn(name = "user_cat_id", nullable = true)
    private List<UserCat> catList;
    @OneToMany
    @JoinColumn(name = "user_dog_id", nullable = true)
    private List<UserDog> dogList;

    public User(long chatId) {
        this.chatId = chatId;
    }

    public User(long chatId, String name) {
        this.chatId = chatId;
        this.name = name;
    }
}
