package com.example.spring1.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.CascadeType;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class deliveryModel {
    @Id
    private int delNo;
    
    // @OneToOne(cascade=CascadeType.ALL)
    // @JsonManagedReference
    // private FoodModel fm;
}
