package com.techelevator.model;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ingredient")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Ingredient {

    //Getting rid of the generation maybe?!
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredientid")
    private Integer ingredientid;

    @Column(name = "name")
    @NotNull
    private String name;

}