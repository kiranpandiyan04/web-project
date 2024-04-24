package com.example.spring1.controller;

import  java.util.List;

// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring1.model.FoodModel;
import com.example.spring1.model.deliveryModel;
import com.example.spring1.service.DeliServices;
import com.example.spring1.service.FoodServices;

@RestController
public class FoodController {
    @Autowired
    private FoodServices FoodService;
    @Autowired
    private DeliServices Deliservice;
    
    @PostMapping("/post")
    public String postMethodName(@RequestBody FoodModel Food) {
        FoodService.saveFood(Food);
        return "saved";
    }
    @PostMapping("/postdeli")
    public String postMethodName(@RequestBody deliveryModel Food) {
        Deliservice.saveFood(Food);
        return "saved";
    }
    @GetMapping("/Food/{itemNo}")
    public FoodModel getMethodName(@PathVariable ("itemNo") int a) {
        return FoodService.getFood(a);
    }
    @GetMapping("/Foods")
    public List<FoodModel> getAllMethodName() {
        List<FoodModel> l= FoodService.getAllFood();
        // System.out.println(l.get(0).getDel().getDelNo());
        return l;
    }
    @GetMapping("/delis")
    public List<deliveryModel> getAllMethodNamedelis() {
        
        return Deliservice.getAllFoodsdeli();
    }
    @GetMapping("/deli/{delNo}")
    public deliveryModel getMethodNamedeli(@PathVariable ("delNo") int a) {
        return Deliservice.getFooddeli(a);
    }
    @GetMapping("page/{s}/{pno}")
    public List<FoodModel> pagi(@PathVariable("s")int s,@PathVariable("pno")int pno){
        return FoodService.pagination(s,pno);
    }
    @PutMapping("/Food/{itemNo}")
    public String putMethodName(@PathVariable int itemNo, @RequestBody FoodModel UpdatedFood){
          FoodModel existFood= FoodService.getFood(itemNo);
          if(existFood!=null){
            existFood.setItemNo(UpdatedFood.getItemNo());
            existFood.setName(UpdatedFood.getName());
            existFood.setNos(UpdatedFood.getNos());
            existFood.setPrice(UpdatedFood.getPrice());
            FoodService.saveFood(existFood);
            return "updated";
          }
          else{
            return "No Data Found";
          }
    }
    @DeleteMapping("/Food/{itemNo}")
    public ResponseEntity<String> deleteFood(@PathVariable("itemNo") int itemNo)
    {
        FoodModel existFood = FoodService.getFood(itemNo);
        if(existFood != null)
        {
            FoodService.deleteFood(itemNo);
            return new ResponseEntity<>("Food deleted",HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("No data found",HttpStatus.NOT_ACCEPTABLE);
    } 
    @DeleteMapping("/deleteAll")
    public String deleteAllFoods() {
        FoodService.deleteAllFood();
        return "All foods deleted";
    }
    @DeleteMapping("/deleteAlldelis")
    public String deleteAllFooddelis() {
        Deliservice.deleteAllFooddel();
        return "All fooddelis deleted";
    }
    // @GetMapping("Foodis")
    // public List<FoodModel> getMethodPrice(@RequestParam int price) {
    //     return FoodService.findByPriceLessThan(price);
    // }
    
}