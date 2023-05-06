package best.team.petprojectsquad.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloWorldControllerTest {

    HelloWorldController helloWorldController = new HelloWorldController();

    @Test
    void sendGreetingsTest(){
        String expected = "Hello, World!";
        String actual = helloWorldController.sendGreetings();
        assertEquals(expected, actual);
    }
}