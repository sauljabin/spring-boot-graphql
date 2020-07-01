package app.character.entity;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;
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

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "character_id")
    private Set<Title> titles;

    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "character_id")
    private Set<Alias> aliases;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "characters_houses",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name = "house_id"))
    private Set<House> houses;
}
