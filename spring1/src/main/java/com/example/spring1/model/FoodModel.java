package com.example.spring1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodModel {
    @Id
    private int itemNo;
    private String name;
    private String nos;
    private int price;

    @OneToOne(cascade=CascadeType.ALL)
    // (mappedBy = "fm",cascade=CascadeType.ALL)
    // @JsonBackReference
    private deliveryModel del;
}

