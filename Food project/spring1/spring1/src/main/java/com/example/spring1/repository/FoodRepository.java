package com.example.spring1.repository;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring1.model.FoodModel;

@Repository
public interface FoodRepository extends JpaRepository <FoodModel,Integer>{
    // FoodModel postMethodName(int itemNo);
}