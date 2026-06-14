package com.example.iHungry.Controller;

import com.example.iHungry.DTO.FoodResponseDTO;
import com.example.iHungry.Model.FoodModel;
import com.example.iHungry.ResponseDTO.FoodRequestDTO;
import com.example.iHungry.Respository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.stream;

@RestController("/food")
public class FoodController {

@Autowired
    FoodRepository foodRepository; //injeta automaticamente todos os metodos do repository subistituindo os " news"

    @GetMapping
    public List<FoodResponseDTO> getAll(){
        List <FoodResponseDTO> foodModel = foodRepository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodModel;

    }

    @RequestMapping
        public ResponseEntity create(@RequestParam FoodRequestDTO foodDto){
        FoodModel food = new FoodModel(foodDto);
        foodRepository.save(food);
        return  ResponseEntity.status(HttpStatus.CREATED).body("Adicionado com sucesso!");
    }
}
