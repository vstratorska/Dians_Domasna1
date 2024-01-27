package mk.ukim.finki.dians.service;

import mk.ukim.finki.dians.model.Winery;
import mk.ukim.finki.dians.model.WineryUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    WineryUser addWinerytoFavorites(String username, Long wineryId);

    WineryUser  findByUsername(String username);


}
