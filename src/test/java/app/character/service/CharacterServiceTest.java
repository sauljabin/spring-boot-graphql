package app.character.service;

import app.character.repository.CharacterRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CharacterServiceTest {

    @Test
    void invokeServiceWhenFindAll() {
        CharacterRepository repository = mock(CharacterRepository.class);
        CharacterService service = new CharacterService(repository);

        service.findAll();

        verify(repository).findAll();
    }

}