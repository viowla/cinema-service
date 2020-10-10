package kz.iitu.cinemaservice;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserMovie {

    private List<Movie> userMovies;

    public UserMovie() {
    }

    public UserMovie(List<Movie> userMovies) {
        this.userMovies = userMovies;
    }
}
