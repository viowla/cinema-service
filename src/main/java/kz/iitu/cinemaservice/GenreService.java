package kz.iitu.cinemaservice;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GenreService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand()
    public Genre getMovieGenre(String movieId) {
        return restTemplate.getForObject(
                "http://movie-genre-service/genre/" + movieId,
                Genre.class);
    }

    public Genre getMovieGenreFallback(String movieId, String genreId) {
        return new Genre(movieId, genreId);
    }
}
