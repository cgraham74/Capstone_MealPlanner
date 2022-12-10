//package com.techelevator.controller;
//
//import com.techelevator.dto.RecipeDTO;
//import com.techelevator.service.Services;
//import lombok.AllArgsConstructor;
//import lombok.NoArgsConstructor;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.web.bind.annotation.*;
//import java.security.Principal;
//import java.util.Collection;
//
//@CrossOrigin
//@RestController
//@RequestMapping(path = "/recipe/stop")
//@AllArgsConstructor
//@NoArgsConstructor
//@EnableWebSecurity
//@Secured({"ROLE_USER", "ROLE_ADMIN"})
//public class MainController {
//
 //   private final Services services;
//
//    @PreAuthorize("permitAll")
//    @GetMapping(path = "/breakfast")
//    public Collection<RecipeDTO> getRecipeTitleFromBreakfast() {
//        return services.listOfRecipesByCategory("Breakfast");
//    }
//    @PreAuthorize("permitAll")
//    @GetMapping(path = "/lunch")
//    public Collection<RecipeDTO> getRecipeTitleFromLunch() {
//        return services.listOfRecipesByCategory("Lunch");
//    }
//    @PreAuthorize("permitAll")
//    @GetMapping(path = "/dinner")
//    public Collection<RecipeDTO> getRecipeTitleFromDinner() {
//        return services.listOfRecipesByCategory("Dinner");
//    }
//
//    @GetMapping(path = "/get/{recipeid}")
//    public RecipeDTO testGetRecipeById(@PathVariable("recipeid") Integer recipeid) {
//        return services.getRecipeById(recipeid);
//    }
//
//    @PutMapping(path = "/update/{id}")
//    public void update(@RequestBody RecipeDTO recipeDTO, @PathVariable int id) {
//        System.out.println("Update was touched! Current Id: " + id);
//        recipeDTO.setRecipeid(id);
//        System.out.println("The recipeDTO's id! " + recipeDTO.getRecipeid());
//        services.deleteRecipeIngredientsByRecipeId(recipeDTO.getRecipeid());
//        services.updateRecipe(recipeDTO);
//    }
//}
//
////    @GetMapping(path = "/list")
////    public Collection<RecipeDTO> getRecipeList(Principal principal){
////        return services.listOfUsersRecipes(principal.getName());
////    }
////
////    //Get a list of ALL recipes in the system.
////    @GetMapping(path = "/listall")
////    public Collection<RecipeDTO> getAllRecipeList(){
////        return services.listOfAllRecipesByDistinctTitle();
////    }
//
////    @PostMapping(path = "/save")
////    @ResponseBody
////    public void saveRecipe(@RequestBody RecipeDTO recipeDTO, Principal principal) {
////        System.out.println("Save Recipe was pinged by: " + principal.getName());
////        System.out.println("The recipeDTO: " + recipeDTO.getTitle());
////        services.saveRecipeAndIngredients(recipeDTO);
////    }
////}
//
//    //UNCOMMENT IF YOU DARE!
//
////    @PermitAll
////    @DeleteMapping(path = "/delete/{id}")
////    public void deleteRecipe(@PathVariable("id") int id) {
////        services.deleteRecipe(id);
//
//
//
