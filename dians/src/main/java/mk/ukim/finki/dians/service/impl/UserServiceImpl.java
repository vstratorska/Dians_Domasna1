package mk.ukim.finki.dians.service.impl;

import mk.ukim.finki.dians.model.Winery;
import mk.ukim.finki.dians.model.WineryUser;
import mk.ukim.finki.dians.repository.UserRepository;
import mk.ukim.finki.dians.service.UserService;
import mk.ukim.finki.dians.service.WineriesService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final WineriesService wineriesService;


    public UserServiceImpl(UserRepository userRepository, WineriesService wineriesService) {
        this.userRepository = userRepository;
        this.wineriesService = wineriesService;
    }
//Dodavanje na vinarija vo lista na omileni na odreden user
    @Override
    public WineryUser addWinerytoFavorites(String username, Long wineryId) {

        WineryUser user=userRepository.findByUsername(username);
        Optional<Winery> winery=wineriesService.findById(wineryId);
        user.getFavorites().add(winery.get());
        return userRepository.save(user);
    }

    @Override
    public WineryUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        WineryUser user=userRepository.findByUsername(username);

        return new User(user.getUsername(), user.getPassword(), Collections.singletonList(user.getRole()));
    }
}
