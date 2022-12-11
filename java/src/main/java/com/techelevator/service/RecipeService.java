package com.techelevator.service;

import com.techelevator.model.Recipe;

import com.techelevator.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Secured({"ROLE_USER", "ROLE_ADMIN"})
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    UserRepository userRepository;

    //Returns a list of recipes by Use
    public List<Recipe> getAllRecipes(String name){
        return new ArrayList<>(recipeRepository.findAllRecipe(userRepository.getUserIdFromUsername(name)));
    }

    //returns a specific recipe by id.
    public Recipe getRecipeById(Integer id){
        return recipeRepository.recipeById(id);
    }

    //Saves a recipe

    //updates a recipe

    //deletes a recipe


}
