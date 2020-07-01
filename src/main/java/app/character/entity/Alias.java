package app.character.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "aliases")
@EqualsAndHashCode(of = "aliasId")
@Builder
public class Alias {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID aliasId;

    private String alias;
}
