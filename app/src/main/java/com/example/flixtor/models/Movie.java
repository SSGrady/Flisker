package com.example.flixtor.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import org.parceler.Parcel;


@Parcel
// "A model class to use as the data source"
public class Movie {

    String backdropPath;
    String posterPath;
    String title;
    String overview;
    Double voteAverage;

    // no-arg, empty constructor required for Parceler
    public Movie() {}

    //    throws JSONException is used instead of try-catch statements.
    public Movie(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        voteAverage = jsonObject.getDouble("vote_average");
    }

    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        int i;
        for (i = 0; i < movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }
    public String getBackdropPath() {
        return String.format("https://images.tmdb.org/t/p/w342/%s", backdropPath);
    }

    //    right click + generate + select all members of the Movie class = auto-generated getters
    public String getPosterPath() {
    //        w342 = with of 342.
        return String.format("https://images.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
    public Double getVoteAverage() {
        return voteAverage;
    }
}
