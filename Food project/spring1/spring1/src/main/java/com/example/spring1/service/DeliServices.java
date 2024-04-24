package com.example.spring1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.spring1.model.deliveryModel;
import com.example.spring1.repository.DELI;

@Service
public class DeliServices {
    @Autowired
    private DELI DEL;

    public deliveryModel saveFood(deliveryModel Food)
    {
        return DEL.save(Food);
    }
    public List<deliveryModel> getAllFoodsdeli()
    {
        return DEL.findAll();
    }
    public deliveryModel getFooddeli(int delNo)
    {
        return DEL.findById(delNo).orElse(null);
    }
    public void deleteAllFooddel() 
    {
        DEL.deleteAll();
    }
}