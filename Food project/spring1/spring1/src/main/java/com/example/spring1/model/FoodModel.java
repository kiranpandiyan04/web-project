package com.example.spring1.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    @JsonManagedReference
    private deliveryModel del;

    @OneToMany(mappedBy = "fm",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<groceryModel>  gm;

}

