package mk.ukim.finki.dians.web;

import mk.ukim.finki.dians.model.Winery;
import mk.ukim.finki.dians.model.WineryUser;
import mk.ukim.finki.dians.service.UserService;
import mk.ukim.finki.dians.service.WineriesService;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/user/favorites")
public class RestController {

    private final UserService userService;
    private final WineriesService wineriesService;

    public RestController(UserService userService, WineriesService wineriesService) {
        this.userService = userService;
        this.wineriesService = wineriesService;
    }

//Prikazuvanje na podatoci vo json format za vinariite koi se vo listata na omileni na najaveniot user
    @GetMapping
    public ResponseEntity<List<Winery>> findFavoritesForLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            // User is not authenticated
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        String username = authentication.getName();
        WineryUser loggedInUser = this.userService.findByUsername(username);

        if (loggedInUser != null) {
            List<Winery> wineries = loggedInUser.getFavorites();

            if (!wineries.isEmpty()) {
                return ResponseEntity.ok().body(wineries);
            } else {
                // User has no favorite wineries
                return ResponseEntity.noContent().build();
            }
        } else {
            // User not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
