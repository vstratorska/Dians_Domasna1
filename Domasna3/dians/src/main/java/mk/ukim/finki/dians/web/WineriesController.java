package mk.ukim.finki.dians.web;

import mk.ukim.finki.dians.model.Winery;
import mk.ukim.finki.dians.model.enumeration.Region;
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

    public WineriesController(WineriesServiceImpl wineriesService) {
        this.wineriesService = wineriesService;
    }

    @GetMapping
    public String getWineryPage(){

        return "test-findmywine";
    }

    @GetMapping("/contact")
    public String getContacts(){

        return "test-contact";
    }


    @PostMapping("/region")
    public String wineriesByRegion(@RequestParam Region region, Model model){
        List<Winery> wineries = wineriesService.findByRegion(region);
        model.addAttribute("region",region);
        model.addAttribute("wineries",wineries);
        return "test-winebyregion";
    }

    @PostMapping("/region/winery")
    public String getWinery(@RequestParam Long id, Model model){
        Optional<Winery> winery = wineriesService.findById(id);
        model.addAttribute("winery", winery);
        return "test-winery";
    }

    @PostMapping("/search")
    public String getBySearch(@RequestParam String name, Model model){
        Optional<Winery> winery = wineriesService.findByName(name);
        model.addAttribute("winery", winery);
        return "test-winery";
    }

}
