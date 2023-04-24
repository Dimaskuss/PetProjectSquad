package best.team.petprojectsquad.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * класс волонтера
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "super_user")
public class SuperUserVolunteer {
    @Id
    @OrderColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "chat_id")
    private Long chatId;

    public SuperUserVolunteer(Long chatId) {
        this.chatId = chatId;
    }
}
