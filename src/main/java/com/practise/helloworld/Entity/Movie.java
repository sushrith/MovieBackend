package com.practise.helloworld.Entity;

import javax.persistence.*;

@Entity
@Table(name="movie")
public class Movie {

    @Id
    @GeneratedValue
    private int id;
    @Column(name="movie_id")
    private String movieId;
    @Column(name="title")
    private String title;
    @Column(name="imdbrating")
    private String imDbRating;
    @Column(name="plot")
    private String plot;
    @Column(name="runtimestr")
    private String runtimeStr;
    @Column(name="movieuser_email")
    private String movieUserEmail;
    @Column(name="image")
    private String image;

    public Movie() {
    }

    public Movie(int id, String movieId, String title, String imDbRating, String plot, String runtimeStr, String movieUserEmail, String image) {
        this.id = id;
        this.movieId = movieId;
        this.title = title;
        this.imDbRating = imDbRating;
        this.plot = plot;
        this.runtimeStr = runtimeStr;
        this.movieUserEmail = movieUserEmail;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return imDbRating;
    }

    public void setRating(String imDbRating) {
        this.imDbRating = imDbRating;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }


    public String getMovieUserEmail() {
        return movieUserEmail;
    }

    public void setMovieUserEmail(String movieUserEmail) {
        this.movieUserEmail = movieUserEmail;
    }

    public String getRuntime() {
        return runtimeStr;
    }

    public void setRuntime(String runtimeStr) {
        this.runtimeStr = runtimeStr;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
