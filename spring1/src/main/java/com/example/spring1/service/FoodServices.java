package com.example.spring1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring1.model.FoodModel;
import com.example.spring1.repository.FoodRepository;

@Service
public class FoodServices {
    @Autowired
    private FoodRepository FoodRepository;

    public FoodModel saveFood(FoodModel Food)
    {
        return FoodRepository.save(Food);
    }
    public FoodModel getFood(int price)
    {
        return FoodRepository.findById(price).orElse(null);
    }
    public List<FoodModel> getAllFood()
    {
        return FoodRepository.findAll();
    }
    public List<FoodModel> getAllFoods()
    {
        return FoodRepository.findAll();
    }
    public void deleteFood(int id)
    {
        FoodRepository.deleteById(id);
    }
    public void deleteAllFood() 
    {
        FoodRepository.deleteAll();
    }
    // public List<FoodModel> findByPriceLessThan(int price) {
    //     return FoodRepository.findByPriceLessThan(price);
    // }
}