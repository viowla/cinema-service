package kz.iitu.cinemaservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    RestTemplate restTemplate;


    public UserMovie getUserMovie(String userId){
        UserMovie userMovie = restTemplate.getForObject("http://user-movie-service"+
                userId, UserMovie.class);
        return userMovie;
    }

}
