package best.team.petprojectsquad.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "cat")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OrderColumn
    private long id;
    @Column(name = "breed")
    private String breed;
    @Column(name = "cat_name")
    private String name;
    @Column(name = "year_of_birthday")
    private int yearOfBirthday;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "id")
    private List<UserCat> userCat;

    public Cat(long id, String breed, String name, int yearOfBirthday, String description) {
        this.id = id;
        this.breed = breed;
        this.name = name;
        this.yearOfBirthday = yearOfBirthday;
        this.description = description;
    }
}
