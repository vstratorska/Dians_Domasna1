package mk.ukim.finki.dians.model;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.dians.model.enumeration.Role;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class WineryUser {

    public WineryUser() {
    }

    public WineryUser(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.favorites=new ArrayList<>();
    }

    @Id
    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany
    private List<Winery> favorites;


}
