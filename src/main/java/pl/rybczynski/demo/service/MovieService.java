package pl.rybczynski.demo.service;

import pl.rybczynski.demo.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> findAll();

    Optional<Movie> findById(long id);

    Movie addMovie(Movie movie);

    Optional<Movie> updateMovie(long id, Movie movie);

    void deleteMovie(long id);

    void setAvailable(long id);

    void setUnavailable(long id);
}
