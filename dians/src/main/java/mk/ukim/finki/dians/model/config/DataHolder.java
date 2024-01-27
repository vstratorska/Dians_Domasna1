package mk.ukim.finki.dians.model.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.dians.model.WineryUser;
import mk.ukim.finki.dians.model.enumeration.Role;
import mk.ukim.finki.dians.repository.UserRepository;
import mk.ukim.finki.dians.repository.WineriesRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
// DataHolder vo koj se cuvaat inMemory useri
@Component
public class DataHolder {

    public static List<WineryUser> users = null;
    private final UserRepository userRepository;

    private final WineriesRepository wineriesRepository;
    private final PasswordEncoder passwordEncoder;

    public DataHolder(UserRepository userRepository, WineriesRepository wineriesRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.wineriesRepository = wineriesRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init()
    {
        userRepository.save(new WineryUser("user1", passwordEncoder.encode("pass1"), Role.ROLE_USER));
        userRepository.save(new WineryUser("user2", passwordEncoder.encode("pass2"), Role.ROLE_USER));
        userRepository.save(new WineryUser("user3", passwordEncoder.encode("pass3"), Role.ROLE_USER));
    }


}
