package com.topcinema.repos;

import com.topcinema.domain.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MovieRepo extends CrudRepository<Movie, Long> {

    List<Movie> findByTitle(String title);

}
