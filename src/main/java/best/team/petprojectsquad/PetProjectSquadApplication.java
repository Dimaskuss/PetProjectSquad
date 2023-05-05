package best.team.petprojectsquad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Аннотация @EnableCaching означает, что мы даем свое согласие на кеширование данных, например {@link best.team.petprojectsquad.repository.CatRepository}
 */
@EnableCaching
@SpringBootApplication
public class PetProjectSquadApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetProjectSquadApplication.class, args);
    }
}
