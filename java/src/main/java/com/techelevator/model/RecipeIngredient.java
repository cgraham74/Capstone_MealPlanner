package com.techelevator.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "recipeingredient")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RecipeIngredient implements Serializable {


    @Column(name = "recipeid")
    @NotNull
    private Integer recipeid;

    @Id
    @Column(name = "ingredientid")
    @NotNull
    private Integer ingredientid;

    @Column(name = "quantity")
    @NotNull
    private String quantity;

    @Column(name = "measurementunit")
    @NotNull
    private String measurementunit;

}

