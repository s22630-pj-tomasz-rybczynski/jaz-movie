package pl.rybczynski.demo.service;

import org.springframework.stereotype.Service;
import pl.rybczynski.demo.model.Movie;
import pl.rybczynski.demo.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepo;

    public MovieServiceImpl(MovieRepository movieRepo) {
        this.movieRepo = movieRepo;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepo.findAll();
    }

    @Override
    public Optional<Movie> findById(long id) {
        return movieRepo.findById(id);
    }

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepo.save(movie);
    }

    @Override
    public Optional<Movie> updateMovie(long id, Movie movie) {
        Optional<Movie> movieById = findById(movie.getId());

        return movieById.map(m -> movieRepo.save(new Movie(id, movie.getTitle(), movie.getCategory())));
    }

    @Override
    public void deleteMovie(long id) {
        movieRepo.deleteById(id);
    }
}
