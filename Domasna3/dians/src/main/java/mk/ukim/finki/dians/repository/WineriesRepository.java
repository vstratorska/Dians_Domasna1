package mk.ukim.finki.dians.repository;

import mk.ukim.finki.dians.model.Winery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineriesRepository extends JpaRepository<Winery,Long>{
}
