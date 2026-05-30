package com.example.starsgallery.service;

import com.example.starsgallery.R;
import com.example.starsgallery.beans.Star;
import java.util.ArrayList;
import java.util.List;

public class StarData {
    public static List<Star> getInitialStars() {
        List<Star> stars = new ArrayList<>();
        stars.add(new Star("Jon Snow", R.drawable.johnny_depp, 5.0f));
        stars.add(new Star("Daenerys Targaryen", R.drawable.emma_watson, 4.8f));
        stars.add(new Star("Tyrion Lannister", R.drawable.robert_downey_jr, 4.9f));
        stars.add(new Star("Arya Stark", R.drawable.zendaya, 4.7f));
        stars.add(new Star("Sansa Stark", R.drawable.natalie_portman, 4.5f));
        stars.add(new Star("Cersei Lannister", R.drawable.angelina_jolie, 4.3f));
        stars.add(new Star("Jaime Lannister", R.drawable.brad_pitt, 4.6f));
        stars.add(new Star("Ned Stark", R.drawable.leonardo_dicaprio, 4.9f));
        stars.add(new Star("The Hound", R.drawable.dwayne_johnson, 4.4f));
        stars.add(new Star("Khal Drogo", R.drawable.tom_cruise, 4.2f));
        stars.add(new Star("Brienne of Tarth", R.drawable.margot_robbie, 4.7f));
        stars.add(new Star("Melisandre", R.drawable.scarlett_johansson, 4.1f));
        return stars;
    }
}
