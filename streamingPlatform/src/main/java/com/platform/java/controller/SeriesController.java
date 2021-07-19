package com.platform.java.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.platform.java.entity.Series;
import com.platform.java.service.SeriesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeriesController {
    @Autowired
    private SeriesService service;

    @CrossOrigin
    @PostMapping("/series/add")
    public Map<String, Boolean> addSeries(@RequestBody Series s1){
        if(service.addSeriesToDB(s1)){
            return Collections.singletonMap("success", true);
        }
        else{
            return Collections.singletonMap("failed", false);
        }
    }

    @CrossOrigin
    @GetMapping("/series/getALL")
    public List<Series> getAllSeries(){
        return service.getAllSeriesFromDB();
    }

    @CrossOrigin
    @GetMapping("/series/getByCategory/{categoryName}")
    public List<Series> getSeriesByCategory(@PathVariable("categoryName") String categoryName){
        return service.getSeriesByCategory(categoryName);
    }
}
