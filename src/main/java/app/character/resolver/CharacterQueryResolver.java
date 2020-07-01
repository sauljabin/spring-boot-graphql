package app.character.resolver;

import app.character.entity.Character;
import app.character.service.CharacterService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CharacterQueryResolver implements GraphQLQueryResolver {

    private final CharacterService characterService;

    @Autowired
    public CharacterQueryResolver(CharacterService characterService) {
        this.characterService = characterService;
    }

    public Iterable<Character> characters() {
        return characterService.findAll();
    }
}
