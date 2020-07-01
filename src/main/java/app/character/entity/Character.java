package app.character.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
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
    @Type(type = "uuid-char")
    private UUID characterId;

    @NotNull
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "character_id")
    private List<Title> titles;
}
