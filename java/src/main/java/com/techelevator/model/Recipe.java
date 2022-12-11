package com.techelevator.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "recipe")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Recipe {

    //Generated and Not Null data tables.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipeid")
    private Integer recipeid;

    @Column(name = "user_id")
    @NotNull
    private Long user_id;

    @Column(name = "title")
    @NotNull
    private String title;

    @Column(name = "category")
    @NotNull
    private String category;

    @Column(name = "servingsize")
    @NotNull
    private Integer servingsize;

    @Column(name = "instructions")
    @NotNull
    private String instructions;

    @Column(name = "imagename")
    private String imagename;

    @ManyToMany
    @JoinTable(name = "recipeingredient",
            joinColumns = @JoinColumn(name = "recipeid"),
            inverseJoinColumns = @JoinColumn(name = "ingredientid"))
    @MapKeyJoinColumn(name = "quantity", referencedColumnName = "quantity")
    @MapKeyJoinColumn(name = "measurementunit", referencedColumnName = "measurementunit")
    private List<Ingredient> ingredients;



}



