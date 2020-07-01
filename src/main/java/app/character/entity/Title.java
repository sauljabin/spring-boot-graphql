package app.character.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "titles")
@EqualsAndHashCode(of = "titleId")
@Builder
public class Title {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID titleId;

    private String title;
}
