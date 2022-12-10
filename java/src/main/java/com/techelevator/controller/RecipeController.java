package com.techelevator.controller;

import com.techelevator.model.Recipe;
import com.techelevator.service.RecipeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/recipe")
@AllArgsConstructor
@NoArgsConstructor
@EnableWebSecurity
@Secured({"ROLE_USER", "ROLE_ADMIN"})
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    //Get a list of all the recipes
//    @GetMapping()
//    @PreAuthorize("hasRole('ROLE_USER')")
//    public List<Recipe> getAllRecipes(Principal principal){
//      System.out.println(principal.getName());
//        return recipeService.listOfUserRecipes(principal.getName());
//    }
////

    @GetMapping
    public List<Recipe> getUserRecipes(){
        return recipeService.getAllRecipes();
    }

//    //Save the recipe
//    @PostMapping("/save")
//    @ResponseBody
//    public void saveRecipe(@RequestBody Recipe recipe, Principal principal) {
//        System.out.println("Save Recipe was pinged by: " + principal.getName());
//        System.out.println("The recipeDTO: " + recipe.getTitle());
//        recipeService.saveRecipe(recipe);
//    }

//    @PutMapping("/update/{id}")
//    public void update(@RequestBody Recipe recipe, @PathVariable int id) {
//        System.out.println("Update was touched! Current Id: " + id);
//        recipe.setRecipeid(id);
//        System.out.println("The recipeDTO's id! " + recipe.getRecipeid());
//        recipeService.updateRecipe(recipe);
//    }

//    //Get a list of recipes by category
//    @GetMapping("/category")
//    public List<Recipe> getCategory(String category){
//        return recipeService.getCategory(category);
//    }

   //Browse public recipes - Will need an API call

//    //Delete a recipe by id
//    @DeleteMapping("/delete/{id}")
//    public void delete(@PathVariable int id){
//        recipeService.deleteRecipeById(id);
//    }

}
