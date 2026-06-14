package com.example.iHungry.Respository;

import com.example.iHungry.Model.FoodModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodModel, Integer>{

}
