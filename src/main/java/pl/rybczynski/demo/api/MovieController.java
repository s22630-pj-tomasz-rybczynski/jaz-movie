package pl.rybczynski.demo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.rybczynski.demo.model.Movie;
import pl.rybczynski.demo.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    final private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> movies() {
        return ResponseEntity.ok(movieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> movieById(@PathVariable Long id) {
        return ResponseEntity.of(movieService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @GetMapping("/set/{id}")
    public ResponseEntity<Movie> setAvailable(@PathVariable Long id) {
        movieService.setAvailable(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/unset/{id}")
    public ResponseEntity<Movie> setUnavailable(@PathVariable Long id) {
        movieService.setUnavailable(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> movieById(@PathVariable Long id, @RequestBody Movie movie) {
        return ResponseEntity.of(movieService.updateMovie(id, movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
       movieService.deleteMovie(id);
       return ResponseEntity.noContent().build();
    }
}
