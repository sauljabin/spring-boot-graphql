package app.character.controller;

import app.character.entity.Character;
import app.character.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController {
    private final CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/characters")
    @ResponseBody
    public Iterable<Character> findAll() {
        return characterService.findAll();
    }
}
