package go.it.springlessons.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String title;
    @Column
    private String content;
}
