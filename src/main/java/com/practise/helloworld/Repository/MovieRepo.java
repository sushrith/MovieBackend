package com.practise.helloworld.Repository;

import com.practise.helloworld.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {
    @Query("select m from Movie m where m.movieUserEmail=?1 and m.movieId=?2")
    Movie findByEmailAndId(String movieUserEmail, String movieId);
    @Query("select m from Movie m where m.movieUserEmail=?1")
    List<Movie> findByMovieUserEmail(String movieUserEmail);
}
