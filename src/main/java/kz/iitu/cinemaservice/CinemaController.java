package kz.iitu.cinemaservice;

import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cinema/api")
public class CinemaController {
    @Autowired
    private MovieService movieService;
    @Autowired
    private GenreService genreService;

    @GetMapping("/{userId}")
    public List<Cinema> getAllMovies(
            @PathVariable String userId) {
        // get all books by userId
        UserMovie  userMovie = movieService.getUserMovie(userId);

        List<Cinema> cinemaList = new ArrayList<>();
        for (Movie movie : userMovie.getUserMovies()) {
            Genre genre = genreService.getMovieGenre(movie.getId());

            cinemaList.add(new Cinema(movie.getTitle(),
                    movie.getOverview(), genre.getGenreId()));
        }

        return cinemaList;
    }
}
