package model;

import javafx.scene.image.Image;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MovieManager {

    private File file = new File("src/files/movies.txt");
    private List<Movie> movies = new ArrayList<Movie>();

    public List<Movie> getMovies() {
        return movies;
    }
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    // load list of movies from file
    public void loadMovies() {
        try {
            FileInputStream fileInput = new FileInputStream(file);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput);
            List<Movie> moviesFromFile = (List<Movie>) objectInput.readObject();
            movies = moviesFromFile;
            objectInput.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    // save list of movies to file
    public void saveMovies() {
        try {
            FileOutputStream fileOutput = new FileOutputStream(file);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(movies);
            objectOutput.close();
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
    // add a new movie to movies list
    public void addMovie(String title, String url){
        // make sure the url works
        // if not, set default that does
        try{
            Image filmPic = new Image(url);
        } catch (Exception e1){
            url = "https://i.pinimg.com/originals/6f/95/e4/6f95e453a08c3e32cbdb0d4eecfd93e9.jpg";
        }
        Movie movie = new Movie(title,url);
        // add new movie to list
        movies.add(movie);
        // save the list
        saveMovies();
    }
}
