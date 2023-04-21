package best.team.petprojectsquad.controller;

import best.team.petprojectsquad.entity.Dog;
import best.team.petprojectsquad.repository.DogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@WebMvcTest(DogController.class)
public class DogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DogRepository dogRepository;

    @Test
    public void testGetDogById() throws Exception {
        long id = 1;
        Dog dog = new Dog();
        dog.setId(id);
        Mockito.when(dogRepository.getReferenceById(id)).thenReturn(dog);
        mockMvc.perform(MockMvcRequestBuilders.get("/Dogs/" + id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));
    }

    @Test
    public void testAddDog() throws Exception {
        Dog dog = new Dog();
        dog.setName("Fido");
        Mockito.when(dogRepository.save(dog)).thenReturn(dog);
        mockMvc.perform(MockMvcRequestBuilders.post("/Dogs/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(dog)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$").value(dog.getId()));
    }

    @Test
    public void testEditDog() throws Exception {
        long id = 1;
        Dog oldDog = new Dog();
        oldDog.setId(id);
        oldDog.setName("Fido");
        Dog newDog = new Dog();
        newDog.setId(id);
        newDog.setName("Max");
        Mockito.when(dogRepository.findById(id)).thenReturn(Optional.of(oldDog));
        Mockito.when(dogRepository.save(newDog)).thenReturn(newDog);
        mockMvc.perform(MockMvcRequestBuilders.put("/Dogs/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(newDog)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$").value(newDog.getId()));
    }

    @Test
    public void testGetAll() throws Exception {
        List<Dog> dogs = new ArrayList<>();
        Dog dog1 = new Dog();
        dog1.setId(1);
        dog1.setName("Fido");
        Dog dog2 = new Dog();
        dog2.setId(2);
        dog2.setName("Max");
        dogs.add(dog1);
        dogs.add(dog2);
        Mockito.when(dogRepository.findAll()).thenReturn(dogs);
        mockMvc.perform(MockMvcRequestBuilders.get("/Dogs/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id").value(dog1.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value(dog1.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].id").value(dog2.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[1].name").value(dog2.getName()));
    }

    @Test
    public void testDeleteDog() throws Exception {
        long id = 1;
        Dog dog = new Dog();
        dog.setId(id);
        Mockito.when(dogRepository.findById(id)).thenReturn(Optional.of(dog));
        mockMvc.perform(MockMvcRequestBuilders.delete("/Dogs/" + id))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(dogRepository, Mockito.times

                (1)).deleteById(id);
    }
}