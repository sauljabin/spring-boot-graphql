package app.character.controller;

import app.character.service.CharacterService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CharacterControllerTest {

    @Test
    void invokeServiceWhenFindAll() {
        CharacterService service = mock(CharacterService.class);
        CharacterController controller = new CharacterController(service);

        controller.findAll();

        verify(service).findAll();
    }
}