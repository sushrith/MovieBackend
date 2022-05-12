package com.practise.helloworld.Repository;

import com.practise.helloworld.Entity.MovieUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<MovieUser, Integer> {

    MovieUser findByEmail(String email);

    @Query("select u.id from MovieUser u where u.email=?1")
    int findIdByEmail(String email);
}
