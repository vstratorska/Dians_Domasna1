package mk.ukim.finki.dians.web;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.dians.model.Winery;
import mk.ukim.finki.dians.model.WineryUser;
import mk.ukim.finki.dians.model.enumeration.Region;
import mk.ukim.finki.dians.repository.UserRepository;
import mk.ukim.finki.dians.service.UserService;
import mk.ukim.finki.dians.service.impl.WineriesServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/findmywine")
public class WineriesController {
    private final WineriesServiceImpl wineriesService;
    private final UserService userService;

    public WineriesController(WineriesServiceImpl wineriesService,  UserService userService) {
        this.wineriesService = wineriesService;
        this.userService = userService;
    }

//Se prikazuva pocetnata strana
    @GetMapping
    public String getWineryPage(Model model){
        List<Region> regions= List.of(Region.values());
        model.addAttribute("regions", regions);

        return "test-findmywine";
    }

//Se prikazuva contact stranata
    @GetMapping("/contact")
    public String getContacts(){

        return "test-contact";
    }
//Se prikazuva strana so iminjata na site vinarii od bazata
    @GetMapping("/all")
    public String getAllWineries(Model model){

        List<Winery> wineries=wineriesService.findAll();
        model.addAttribute("wineries", wineries);
        return "test-all";
    }

//Se prikazuva strana so iminjata na site vinarii vo odreden region
    @PostMapping("/region")
    public String wineriesByRegion(@RequestParam String reg, Model model){
        List<Winery> wineries = wineriesService.findByRegion(Region.valueOf(reg));

        model.addAttribute("region",reg);
        model.addAttribute("wineries",wineries);
        return "test-winebyregion";
    }
//Se prikazuva strana so informaciite za odredena vinarija
    @PostMapping("/region/winery")
    public String getWinery(@RequestParam Long id, Model model){
        Optional<Winery> winery = wineriesService.findById(id);
        model.addAttribute("winery", winery);
        return "test-winery";
    }

//Se prikazuva strana so informaciite za odredena vinarija koja se prebaruvana preku search poleto
    @PostMapping("/search")
    public String getBySearch(@RequestParam String name, Model model){
        Optional<Winery> winery = wineriesService.findByName(name);
        model.addAttribute("winery", winery);
        return "test-winery";
    }

//Se prikazuva strana so informaciite za odredena vinarija otkako e dodadena vo lista na omileni
    @GetMapping("/region/winery/{id}")
    public String getWinery2(@PathVariable Long id, Model model){
        Optional<Winery> winery = wineriesService.findById(id);
        model.addAttribute("winery", winery);
        return "test-winery";
    }


    @PostMapping("/favorites/{id}")
    public String addFavorite(@PathVariable Long id, HttpServletRequest req) {
        String username = req.getRemoteUser();
        userService.addWinerytoFavorites(username, id);
            return "redirect:/findmywine/region/winery/"+id;
    }
}
