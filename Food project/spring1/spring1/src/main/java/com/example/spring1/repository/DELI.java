package com.example.spring1.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring1.model.deliveryModel;

@Repository
public interface DELI extends JpaRepository <deliveryModel,Integer>{
}