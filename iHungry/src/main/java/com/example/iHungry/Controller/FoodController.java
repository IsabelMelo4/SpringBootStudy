package com.example.iHungry.Controller;

import com.example.iHungry.DTO.FoodResponseDTO;
import com.example.iHungry.Model.FoodModel;
import com.example.iHungry.ResponseDTO.FoodRequestDTO;
import com.example.iHungry.Respository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.stream;

@RestController
@RequestMapping("/food")
public class FoodController {

@Autowired
    FoodRepository foodRepository; //injeta automaticamente todos os metodos do repository subistituindo os " news"

    @GetMapping
    public List<FoodResponseDTO> get(){
        List <FoodResponseDTO> foodModel = foodRepository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodModel;

    }

    @RequestMapping
        public ResponseEntity create(@RequestBody FoodRequestDTO foodDto){
        FoodModel food = new FoodModel(foodDto);
        foodRepository.save(food);
        return  ResponseEntity.status(HttpStatus.CREATED).body("Adicionado com sucesso!");
    }

    @DeleteMapping("/{id}")
        public ResponseEntity delete(@PathVariable Integer id){
        foodRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity uptade(@PathVariable Integer id, @RequestBody FoodResponseDTO foodResponseDTO){

     Optional <FoodModel> food = foodRepository.findById(id);

     FoodModel response = food.get();

     response.setName(foodResponseDTO.name());
     response.setPrice(foodResponseDTO.price());
     response.setImage(foodResponseDTO.image());

     foodRepository.save(response);

     return ResponseEntity.status(HttpStatus.OK).body("Atualizado com suscesso");
    }

}
