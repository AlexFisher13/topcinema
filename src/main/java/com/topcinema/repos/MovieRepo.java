package com.topcinema.repos;

import com.topcinema.domain.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepo extends CrudRepository<Movie, Long> {
}
