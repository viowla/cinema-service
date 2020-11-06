package kz.iitu.cinemaservice;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.apache.commons.codec.binary.Base64;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(
            fallbackMethod = "getUserMovieFallback",
            threadPoolKey = "getUserMovie",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "100"),
                    @HystrixProperty(name = "maximumSize", value = "120"),
                    @HystrixProperty(name = "maxQueueSize", value = "50"),
                    @HystrixProperty(name = "allowMaximumSizeToDivergeFromCoreSize", value = "true")
            }
    )
    public UserMovie getUserMovie(String userId){
        String apiCredentials = "rest-client:p@ssword";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("http://cinema-info-service/movie/info/" + userId,
                HttpMethod.GET, entity, UserMovie.class).getBody();
    }

    public UserMovie getUserMovieFallback(String movieId) {
        UserMovie userMovie = new UserMovie();
        List<Movie> list = new ArrayList<>();
        list.add(new Movie("-1", "Not available", "Not available", "Not available"));
        userMovie.setUserMovies(list);

        return userMovie;
    }

}
