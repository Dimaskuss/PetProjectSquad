package best.team.petprojectsquad.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name = "dog")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Dog {
    @Id
    @JsonIgnore
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
    @JsonIgnore
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
