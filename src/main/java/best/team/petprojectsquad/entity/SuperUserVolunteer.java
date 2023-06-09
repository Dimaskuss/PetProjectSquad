package best.team.petprojectsquad.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * класс волонтера
 */
@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "super_user")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SuperUserVolunteer {
    @Id
    @JsonIgnore
    @OrderColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "chat_id")
    private long chatId;

    public SuperUserVolunteer(Long chatId) {
        this.chatId = chatId;
    }

    public SuperUserVolunteer(long chatId, String name) {
        this.chatId = chatId;
        this.name = name;
    }
}
