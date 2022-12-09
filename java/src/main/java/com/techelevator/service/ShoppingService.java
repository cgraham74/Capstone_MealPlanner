package com.techelevator.service;

import com.techelevator.model.ShoppingList;
import com.techelevator.repository.RecipeIngredientRepository;
import com.techelevator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RecipeIngredientRepository recipeIngredientRepository;

    @PostAuthorize("#username == authentication.principal.username")
    public Long getUserId(String username) {
        return userRepository.getUserIdFromUsername(username);
    }
    //Retrieves A List of Ingredients from the users mealPlan repository and returns
    //a list of ingredients to the controller.
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public List<ShoppingList> getMealPlanShoppingListFromUser(String username) {
        return recipeIngredientRepository.getListOfIngredientNames(getUserId(username))
                .stream()
                .map(ShoppingList::new)
                .collect(Collectors.toList());
    }

}
