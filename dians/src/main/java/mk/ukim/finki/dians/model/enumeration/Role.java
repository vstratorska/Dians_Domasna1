package mk.ukim.finki.dians.model.enumeration;

import jakarta.persistence.GeneratedValue;
import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
