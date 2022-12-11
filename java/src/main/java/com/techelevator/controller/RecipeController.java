package com.techelevator.controller;

import com.sun.xml.bind.v2.TODO;
import com.techelevator.model.Recipe;
import com.techelevator.service.RecipeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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

    @GetMapping
    public List<Recipe> getUserRecipes(Principal principal){
        return recipeService.getAllRecipes(principal.getName());
    }

    @GetMapping("{recipeid}")
    public Recipe getRecipe(@PathVariable("recipeid") Integer recipeid){
        return recipeService.getRecipeById(recipeid);
    }
//--TODO
//    //Save the recipe
//    @PostMapping("/save")
//    @ResponseBody
//    public void saveRecipe(@RequestBody Recipe recipe, Principal principal) {
//        System.out.println("Save Recipe was pinged by: " + principal.getName());
//        System.out.println("The recipeDTO: " + recipe.getTitle());
//        recipeService.saveRecipe(recipe);
//    }


//--TODO
//    @PutMapping("/update/{id}")
//    public void update(@RequestBody Recipe recipe, @PathVariable int id) {
//        System.out.println("Update was touched! Current Id: " + id);
//        recipe.setRecipeid(id);
//        System.out.println("The recipeDTO's id! " + recipe.getRecipeid());
//        recipeService.updateRecipe(recipe);
//    }


//--TODO
//    //Delete a recipe by id
//    @DeleteMapping("/delete/{id}")
//    public void delete(@PathVariable int id){
//        recipeService.deleteRecipeById(id);
//    }

}
