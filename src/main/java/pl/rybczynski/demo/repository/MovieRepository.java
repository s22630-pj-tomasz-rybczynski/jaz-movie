package pl.rybczynski.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rybczynski.demo.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
