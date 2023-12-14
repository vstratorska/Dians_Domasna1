package mk.ukim.finki.dians.repository;

import mk.ukim.finki.dians.model.Winery;
import mk.ukim.finki.dians.model.enumeration.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WineriesRepository extends JpaRepository<Winery,Long>{

    List<Winery> findByRegion(Region region);
    Optional<Winery> findByName(String name);
}
