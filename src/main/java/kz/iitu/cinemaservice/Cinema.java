package kz.iitu.cinemaservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cinema {

    private String title;
    private String overview;
    private String genre;

    public Cinema() {
    }

    public Cinema(String title, String overview, String genre) {
        this.title = title;
        this.overview = overview;
        this.genre=genre;
    }
}
