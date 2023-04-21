package best.team.petprojectsquad.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "user")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderColumn
    private long id;
    @Column(name = "chat_id")
    private long chat_id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "user")
    private List<UserCat> catList;

    @OneToMany(mappedBy = "user")
    private List<UserDog> dogList;
}
