package app.character.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "characters")
@EqualsAndHashCode(of = "characterId")
@Builder
public class Character {

    @Id
    @GeneratedValue
    private UUID characterId;
    private String name;
    private Gender gender;
}
