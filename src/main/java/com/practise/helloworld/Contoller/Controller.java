package com.practise.helloworld.Contoller;

import com.practise.helloworld.Entity.Login;
import com.practise.helloworld.Entity.Movie;
import com.practise.helloworld.Entity.MovieUser;
import com.practise.helloworld.Repository.MovieRepo;
import com.practise.helloworld.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class Controller {
    @Autowired
    private Repository userRepository;
    @Autowired
    private MovieRepo movieRepository;
    @PostMapping(path="/addUser")
    public boolean addNewUser (@RequestBody MovieUser user)
    {
        MovieUser u = userRepository.findByEmail(user.getEmail());
        if(u==null)
        {
            userRepository.save(user);
        }else
        {
            return false;
        }
        return true;
    }

    @PostMapping(path="/login")
    public @ResponseBody
    boolean checkUser (@RequestBody Login login)
    {
        MovieUser  u = userRepository.findByEmail(login.getEmail());
        if(u!=null)
        {
            if(!(login.getPassword().equals(u.getPassword())))
            {
                System.out.println("Wrong password");
                return false;
            }
            else
            {
                return true;
            }
        }
        else
            return false;
    }
    @PostMapping(path="/addMovie")
    public boolean addMovieForUser (@RequestBody Movie movie)
    {

        Movie m = movieRepository.findByEmailAndId(movie.getMovieUserEmail(),movie.getMovieId());
        if(m==null)
        {
            movieRepository.save(movie);
        }else
        {
            return false;
        }
        return true;
    }
	 @GetMapping(path="/")
    public String hello()
    {
        return "Hello";
    }
    @GetMapping(path="/getMovieList")
    public List<Movie> getMovieList(@RequestParam("email") String email)
    {
        return movieRepository.findByMovieUserEmail(email);
    }
    @GetMapping(path = "/checkInWishlist")
    public boolean checkInWishlist(@RequestParam("email") String email,@RequestParam("movieId") String id)
    {
        Movie m=movieRepository.findByEmailAndId(email,id);
        if(m!=null)
            return true;
        return false;
    }
    @DeleteMapping(path = "/deleteMovie")
    public boolean delete(@RequestParam("email") String email, @RequestParam("movieId") String id){
        Movie m=movieRepository.findByEmailAndId(email,id);
        if(m==null)
        {
            return false;
        }
        else{
            movieRepository.delete(m);
            return true;
        }

    }
}
