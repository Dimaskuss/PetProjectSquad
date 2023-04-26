package best.team.petprojectsquad.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "dog")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderColumn
    private long id;
    @Column(name = "breed")
    private String breed;
    @Column(name = "dog_name")
    private String name;
    @Column(name = "year_of_birthday")
    private int yearOfBirthday;
    @Column(name = "description")
    private String description;
    @OneToOne(mappedBy = "dog")
    private UserDog userDog;

    public Dog(long id, String breed, String name, int yearOfBirthday, String description) {
        this.id = id;
        this.breed = breed;
        this.name = name;
        this.yearOfBirthday = yearOfBirthday;
        this.description = description;
    }
}
