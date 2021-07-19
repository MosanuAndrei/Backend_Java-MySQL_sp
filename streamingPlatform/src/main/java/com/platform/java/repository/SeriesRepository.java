package com.platform.java.repository;

import java.util.List;

import com.platform.java.entity.Series;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SeriesRepository extends JpaRepository<Series, Integer> {
    
    @Query(value = "select * from Series s join Category c on s.IDCategory = c.IDCategory Where NameCategory = ?1", nativeQuery = true)
    public List<Series> getSeriesByCategoryName(String categoryName);

}
