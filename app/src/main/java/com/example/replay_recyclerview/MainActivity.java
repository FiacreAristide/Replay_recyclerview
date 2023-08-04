package com.example.replay_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private Movie_Adapter adapter;
private List<Movie> movies;
private List<Movie> filteredList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movies = new ArrayList<>();
        movies.add(new Movie("Inception", "Science Fiction", R.drawable.affen));
        movies.add(new Movie("The Dark Knight", "Action", R.drawable.aidi));
        movies.add(new Movie("Pulp Fiction", "Crime", R.drawable.airedaleterrier));
        movies.add(new Movie("Forrest Gump", "Drama", R.drawable.akitaamericain));
        movies.add(new Movie("The Shawshank Redemption", "Drama", R.drawable.akitainu));
        movies.add(new Movie("The Godfather", "Crime", R.drawable.azawakh));
        movies.add(new Movie("Interstellar", "Science Fiction", R.drawable.bergerallemand));
        movies.add(new Movie("Gladiator", "Action", R.drawable.bergerbelge));
        movies.add(new Movie("Titanic", "Drama", R.drawable.bergerblancsuisse));
        movies.add(new Movie("Avatar", "Science Fiction", R.drawable.bergerdasiecentrale));
        movies.add(new Movie("The Lord of the Rings: The Return of the King", "Fantasy", R.drawable.brachetpolonais));
        movies.add(new Movie("Inglourious Basterds", "War", R.drawable.chiencourantfinnois));
        movies.add(new Movie("The Matrix", "Science Fiction", R.drawable.chiendartois));
        movies.add(new Movie("The Silence of the Lambs", "Crime", R.drawable.chiendesainthubert));
        movies.add(new Movie("Goodfellas", "Crime", R.drawable.braquedauvergne));
        movies.add(new Movie("Schindler's List", "Drama", R.drawable.chiendelaserrdaestrelada));




        RecyclerView recyclerView = findViewById(R.id.myrecycler);
        adapter = new Movie_Adapter(this,movies);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        SearchView searchView = findViewById(R.id.searchView);
        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filterList(s);
                return true;
            }
        });
    }

    private void filterList(String s) {
        filteredList = new ArrayList<>();
        for(Movie movie : movies){
            if(movie.getTitle().toLowerCase().contains(s.toLowerCase())||movie.getSubtitle().toLowerCase().contains(s.toLowerCase())){
                filteredList.add(movie);
            }
        }

        if(filteredList.isEmpty()){
            Toast.makeText(this,"Aucun élément ne correspond à ce nom",Toast.LENGTH_LONG).show();
        }else{
            adapter.setFilteredMovies(filteredList);
        }
    }
}