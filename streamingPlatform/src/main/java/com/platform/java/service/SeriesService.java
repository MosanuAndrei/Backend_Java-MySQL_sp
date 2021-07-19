package com.platform.java.service;

import java.util.List;

import com.platform.java.entity.Series;
import com.platform.java.repository.SeriesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeriesService {
    @Autowired
    private SeriesRepository repo;

    public boolean addSeriesToDB(Series s1){
        Series saved = this.repo.save(s1);

        if(saved != null){
            return true;
        }
        else{
            return false;
        }
    }

    public List<Series> getAllSeriesFromDB(){
        return repo.findAll();
    }

    public List<Series> getSeriesByCategory(String categoryName){
        return repo.getSeriesByCategoryName(categoryName);
    }
}
