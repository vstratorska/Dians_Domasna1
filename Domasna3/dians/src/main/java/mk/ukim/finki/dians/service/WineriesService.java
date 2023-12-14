package mk.ukim.finki.dians.service;

import mk.ukim.finki.dians.model.Winery;
import mk.ukim.finki.dians.model.enumeration.Region;

import java.util.List;
import java.util.Optional;

public interface WineriesService {

    public List<Winery> findAll ();
    public List<Winery> findByRegion(Region region);

    public Optional<Winery> findByName(String name);
    public Optional<Winery> findById(Long id);
}
