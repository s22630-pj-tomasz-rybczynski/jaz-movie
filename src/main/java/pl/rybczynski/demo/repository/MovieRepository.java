package pl.rybczynski.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.rybczynski.demo.model.Category;
import pl.rybczynski.demo.model.Movie;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m FROM Movie m")
    List<Movie> findAll();

    @Query("SELECT m FROM Movie m WHERE m.id = ?1")
    Optional<Movie> findById(Long id);

    @Modifying
    @Query(value = "INSERT into Movie (id, title, category) values (:title, :category)", nativeQuery = true)
    Movie save(@Param("title") String title, @Param("category") Category category);

    @Modifying
    @Query("delete from Movie m where m.id=?1")
    void deleteById(Long id);

    @Modifying
    @Query("update Movie m set m.isAvailable = true where m.id = ?1")
    void setAvailable(Long id);
}
