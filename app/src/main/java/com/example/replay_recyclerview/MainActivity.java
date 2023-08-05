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
        movies.add(new Movie("Affenpinscher", "Petit chien d'origine allemande, il est de petite taille avec un caractère vif et intelligent.", R.drawable.affen));
        movies.add(new Movie("Aidi", "Chien berger d'origine marocaine, il est courageux, intelligent et protecteur.", R.drawable.aidi));
        movies.add(new Movie("Airedale Terrier", "Chien terrier d'origine britannique, il est énergique, intelligent et un bon chasseur.", R.drawable.airedaleterrier));
        movies.add(new Movie("Akita Américain", "Chien de grande taille originaire du Japon, il est fidèle, courageux et calme.", R.drawable.akitaamericain));
        movies.add(new Movie("Akita Inu", "Chien de race japonaise, il est puissant, digne et loyal.", R.drawable.akitainu));
        movies.add(new Movie("Azawakh", "Chien originaire d'Afrique de l'Ouest, il est élégant, agile et indépendant.", R.drawable.azawakh));
        movies.add(new Movie("Berger Allemand", "Chien berger allemand, il est intelligent, courageux et loyal.", R.drawable.bergerallemand));
        movies.add(new Movie("Berger Belge", "Chien berger belge, il est vigilant, actif et dévoué.", R.drawable.bergerbelge));
        movies.add(new Movie("Berger Blanc Suisse", "Chien de berger blanc d'origine suisse, il est gentil, intelligent et doux.", R.drawable.bergerblancsuisse));
        movies.add(new Movie("Berger d'Asie Centrale", "Chien de berger d'Asie centrale, il est puissant, courageux et protecteur.", R.drawable.bergerdasiecentrale));
        movies.add(new Movie("Brachet Polonais", "Chien brachet polonais, il est actif, vif et déterminé.", R.drawable.brachetpolonais));
        movies.add(new Movie("Chien Courant Finnois", "Chien courant finnois, il est énergique, endurant et passionné de chasse.", R.drawable.chiencourantfinnois));
        movies.add(new Movie("Chien d'Artois", "Chien d'Artois, il est calme, déterminé et un excellent chasseur.", R.drawable.chiendartois));
        movies.add(new Movie("Chien de Saint-Hubert", "Chien de Saint-Hubert, il est calme, docile et a un excellent odorat.", R.drawable.chiendesainthubert));
        movies.add(new Movie("Braque d'Auvergne", "Braque d'Auvergne, il est amical, doux et un excellent chien de chasse.", R.drawable.braquedauvergne));
        movies.add(new Movie("Affenpinscher", "Petit chien d'origine allemande, il est de petite taille avec un caractère vif et intelligent.", R.drawable.affen));
        movies.add(new Movie("Aidi", "Chien berger d'origine marocaine, il est courageux, intelligent et protecteur.", R.drawable.aidi));
        movies.add(new Movie("Airedale Terrier", "Chien terrier d'origine britannique, il est énergique, intelligent et un bon chasseur.", R.drawable.airedaleterrier));
        movies.add(new Movie("Akita Américain", "Chien de grande taille originaire du Japon, il est fidèle, courageux et calme.", R.drawable.akitaamericain));
        movies.add(new Movie("Akita Inu", "Chien de race japonaise, il est puissant, digne et loyal.", R.drawable.akitainu));
        movies.add(new Movie("Azawakh", "Chien originaire d'Afrique de l'Ouest, il est élégant, agile et indépendant.", R.drawable.azawakh));
        movies.add(new Movie("Berger Allemand", "Chien berger allemand, il est intelligent, courageux et loyal.", R.drawable.bergerallemand));
        movies.add(new Movie("Berger Belge", "Chien berger belge, il est vigilant, actif et dévoué.", R.drawable.bergerbelge));
        movies.add(new Movie("Berger Blanc Suisse", "Chien de berger blanc d'origine suisse, il est gentil, intelligent et doux.", R.drawable.bergerblancsuisse));
        movies.add(new Movie("Berger d'Asie Centrale", "Chien de berger d'Asie centrale, il est puissant, courageux et protecteur.", R.drawable.bergerdasiecentrale));
        movies.add(new Movie("Brachet Polonais", "Chien brachet polonais, il est actif, vif et déterminé.", R.drawable.brachetpolonais));
        movies.add(new Movie("Chien Courant Finnois", "Chien courant finnois, il est énergique, endurant et passionné de chasse.", R.drawable.chiencourantfinnois));
        movies.add(new Movie("Chien d'Artois", "Chien d'Artois, il est calme, déterminé et un excellent chasseur.", R.drawable.chiendartois));
        movies.add(new Movie("Chien de Saint-Hubert", "Chien de Saint-Hubert, il est calme, docile et a un excellent odorat.", R.drawable.chiendesainthubert));




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