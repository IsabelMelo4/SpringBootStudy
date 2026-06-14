package com.example.iHungry.DTO;

import com.example.iHungry.Model.FoodModel;

public record FoodResponseDTO(String name, Long price, String image, Integer id){

    public FoodResponseDTO(FoodModel foodModel){
   this( foodModel.getName(), foodModel.getPrice(),foodModel.getImage(), foodModel.getId());
}

}

