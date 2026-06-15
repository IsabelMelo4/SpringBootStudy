package com.example.iHungry.Model;

import com.example.iHungry.ResponseDTO.FoodRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Getter
@Setter //ambas são anotações do lombok que supre a nescessidade de criar os getters e setters
@NoArgsConstructor
@AllArgsConstructor
@SpringBootApplication //essa anotação serve para indicar que essa classe é a que vai executar a aplicação spring

@Entity
@Table(name = "food")
public class FoodModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //indica que o id vai ser gerado como identity
    private Integer id;
    private String name;
    private long price;
    private String image;


    public FoodModel(FoodRequestDTO foodRequestDTO) {

        this.name = foodRequestDTO.name();
        this.price = foodRequestDTO.price();
        this.image = foodRequestDTO.image();
    }
}
