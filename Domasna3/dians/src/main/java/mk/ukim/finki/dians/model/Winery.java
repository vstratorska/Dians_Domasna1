package mk.ukim.finki.dians.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.dians.model.enumeration.Region;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Winery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private String phone;
    private String wp;
    private String hours;
    private String menu;
    private String photo;
    private String rating;

    @Enumerated(EnumType.STRING)
    private Region region;


}
