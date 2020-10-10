package kz.iitu.cinemaservice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cinema {

    private String title;
    private String overview;

    public Cinema() {
    }

    public Cinema(String title, String overview) {
        this.title = title;
        this.overview = overview;
    }
}
