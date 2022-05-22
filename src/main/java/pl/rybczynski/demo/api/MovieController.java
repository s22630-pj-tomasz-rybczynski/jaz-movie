package pl.rybczynski.demo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.rybczynski.demo.model.Movie;
import pl.rybczynski.demo.service.MovieService;
import pl.rybczynski.demo.service.MovieServiceImpl;

import java.util.List;

@RestController
public class MovieController {

    final private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> movies() {
        return ResponseEntity.ok(movieService.findAll());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> movieById(@PathVariable Long id) {
        return ResponseEntity.of(movieService.findById(id));
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> movieById(@PathVariable Long id, @RequestBody Movie movie) {
        return ResponseEntity.of(movieService.updateMovie(id, movie));
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
       movieService.deleteMovie(id);
       return ResponseEntity.noContent().build();
    }
}
