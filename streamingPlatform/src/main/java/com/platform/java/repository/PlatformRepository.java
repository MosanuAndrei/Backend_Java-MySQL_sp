package com.platform.java.repository;

import com.platform.java.entity.Platform;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<Platform, Integer>{
    
}
