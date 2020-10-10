package kz.iitu.cinemaservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {

    private String id;
    private String title;
    private String overview;
    private String genres;

    public Movie() {
    }

    public Movie(String id, String title, String overview, String genres) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.genres = genres;
    }
}
