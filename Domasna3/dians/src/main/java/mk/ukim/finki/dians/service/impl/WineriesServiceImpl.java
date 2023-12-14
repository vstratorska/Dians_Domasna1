package mk.ukim.finki.dians.service.impl;

import mk.ukim.finki.dians.repository.WineriesRepository;
import mk.ukim.finki.dians.service.WineriesService;
import org.springframework.stereotype.Service;

@Service
public class WineriesServiceImpl implements WineriesService {
    private final WineriesRepository wineriesRepository;

    public WineriesServiceImpl(WineriesRepository wineriesRepository) {
        this.wineriesRepository = wineriesRepository;
    }


}
