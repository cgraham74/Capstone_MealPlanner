package com.techelevator.service;

import com.techelevator.model.Recipe;

import com.techelevator.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;


    public List<Recipe> getAllRecipes(){
        return new ArrayList<>(recipeRepository.findAllRecipe());
    }

    //returns a list of the current logged-in users recipes.
//    public List<Recipe> listOfUserRecipes(String name) {
//        System.out.println("USER ID :"+userRepository.getUserIdFromUsername(name));
//        List<Recipe> recipes = new ArrayList<>();
//        recipes.add(recipeRepository.findByUser(userRepository.getUserIdFromUsername(name))
//                .stream()
//                .map(recipe -> new Recipe(recipe))
//                .collect(Collectors.toList()));
//   // recipeRepository.findByUser(userRepository.getUserIdFromUsername(name));
//
//        return recipes;
//    }

//    //returns a list of recipes by category
//    public List<Recipe> getCategory(String category) {
//        return recipeRepository.recipeByCategory(category);
//    }

//    //returns a specific recipe by id.
//    public Recipe getRecipeById(Integer id){
//        return recipeRepository.recipeById(id);
//    }

    //Saves a recipe

    //updates a recipe


    //deletes a recipe


}
