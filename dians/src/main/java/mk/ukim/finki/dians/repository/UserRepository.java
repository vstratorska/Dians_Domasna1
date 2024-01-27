package mk.ukim.finki.dians.repository;

import mk.ukim.finki.dians.model.Winery;
import mk.ukim.finki.dians.model.WineryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<WineryUser, String> {

    WineryUser findByUsername(String username);

}
