package best.team.petprojectsquad.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderColumn
    private long id;
    @Column(name = "chat_id")
    private long chatId;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "user")
    private List<UserCat> userCat;
    @OneToMany(mappedBy = "user")
    private List<UserDog> userDog;


    //TODO: phone сделать, сделать перенос в user_feedback

    public User(long chatId) {
        this.chatId = chatId;
    }

    public User(long chatId, String name) {
        this.chatId = chatId;
        this.name = name;
    }
}
