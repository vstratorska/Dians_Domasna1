package mk.ukim.finki.dians.service.impl;

import mk.ukim.finki.dians.model.Winery;
import mk.ukim.finki.dians.model.enumeration.Region;
import mk.ukim.finki.dians.repository.WineriesRepository;
import mk.ukim.finki.dians.service.WineriesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WineriesServiceImpl implements WineriesService {
    private final WineriesRepository wineriesRepository;

    public WineriesServiceImpl(WineriesRepository wineriesRepository) {
        this.wineriesRepository = wineriesRepository;
    }


    @Override
    public List<Winery> findAll() {
        return wineriesRepository.findAll();
    }

    @Override
    public List<Winery> findByRegion(Region region) {
        return wineriesRepository.findByRegion(region);
    }

    @Override
    public Optional<Winery> findByName(String name) {
        return wineriesRepository.findByName(name);
    }

    @Override
    public Optional<Winery> findById(Long id) {
        return wineriesRepository.findById(id);
    }
}
