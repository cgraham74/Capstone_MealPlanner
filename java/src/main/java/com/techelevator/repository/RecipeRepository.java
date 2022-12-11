package com.techelevator.repository;

import com.techelevator.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    //Queries for a list of recipes by user id
    @Query("SELECT r FROM Recipe r WHERE r.user_id = :user_id")
    List<Recipe> findAllRecipe(@Param("user_id") Long user_id);

    //Queries for a single recipe by recipeid
    @Query("SELECT r FROM Recipe r WHERE r.recipeid = :recipeid")
    Recipe recipeById(@Param("recipeid")Integer recipeid);

//---------------Haven't tested below this line
    @Query("SELECT r FROM Recipe r WHERE r.category LIKE :category")
    List<Recipe> getRecipeTitleByCategory(@Param("category") String category);


    @Query("SELECT r FROM Recipe r WHERE r.user_id = :user_id")
    List<Recipe> getAllUsersRecipes(@Param("user_id") Long user_id);

    @Query("SELECT r FROM Recipe r WHERE r.user_id = :user_id")
    List<Recipe> findByUser(@Param("user_id") Long user_id);

    @Query(value = "SELECT DISTINCT ON (title) * FROM recipe", nativeQuery = true)
    List<Recipe> getDistinctTitleRecipes();

    @Query("SELECT r FROM Recipe r WHERE r.title LIKE :title AND r.user_id = :user_id")
    Recipe recipeByTitleAndUser(@Param("title") String title, @Param("user_id") Long user_id);

    @Query("SELECT r FROM Recipe r WHERE r.category LIKE :category")
    List<Recipe> recipeByCategory(@Param("category") String category);
}
