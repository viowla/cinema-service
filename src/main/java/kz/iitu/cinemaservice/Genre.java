package kz.iitu.cinemaservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Genre {
    private String movieId;
    private String genreId;

    public Genre() {
    }

    public Genre(String movieId, String genreId) {
        this.movieId = movieId;
        this.genreId = genreId;
    }
}
