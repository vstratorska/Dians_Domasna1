package mk.ukim.finki.dians.web;

import mk.ukim.finki.dians.model.Winery;
import mk.ukim.finki.dians.model.enumeration.Region;
import mk.ukim.finki.dians.service.impl.WineriesServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/region")
    public String wineriesByRegion(@RequestParam Region region, Model model){
        List<Winery> wineries = wineriesService.findByRegion(region);
        model.addAttribute("region",region);
        model.addAttribute("wineries",wineries);
        return "test-winebyregion";
    }

}
