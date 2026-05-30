package com.example.starsgallery.service;

import com.example.starsgallery.beans.Star;
import com.example.starsgallery.dao.IDao;

import java.util.List;

public class StarService implements IDao<Star> {

    private static StarService instance;
    private final List<Star> starList;

    private StarService() {
        this.starList = StarData.getInitialStars();
    }

    public static StarService getInstance() {
        if (instance == null) {
            instance = new StarService();
        }
        return instance;
    }

    @Override
    public boolean create(Star star) {
        return starList.add(star);
    }

    @Override
    public boolean update(Star updatedStar) {
        for (int i = 0; i < starList.size(); i++) {
            if (starList.get(i).getId() == updatedStar.getId()) {
                starList.set(i, updatedStar);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Star star) {
        return starList.remove(star);
    }

    @Override
    public Star findById(int id) {
        for (Star star : starList) {
            if (star.getId() == id) {
                return star;
            }
        }
        return null;
    }

    @Override
    public List<Star> findAll() {
        return starList;
    }
}