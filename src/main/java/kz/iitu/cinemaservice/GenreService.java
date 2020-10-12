package kz.iitu.cinemaservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GenreService {
    @Autowired
    private RestTemplate restTemplate;

    public Genre getMovieGenre(String movieId) {
        return restTemplate.getForObject(
                "http://movie-genre-service/genre/" + movieId,
                Genre.class);
    }

}
