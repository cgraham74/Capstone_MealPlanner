package com.techelevator.controller;

import com.techelevator.model.ShoppingList;
import com.techelevator.service.ShoppingService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/shopping")
@EnableWebSecurity
@AllArgsConstructor
@Secured({"ROLE_USER", "ROLE_ADMIN"})
public class ShoppingController {

    private ShoppingService shoppingService;

    //Returns the current user's ShoppingList to the viewer.'
    @GetMapping()
    public List<ShoppingList> shoppingList(Principal principal) {
        return shoppingService.getMealPlanShoppingListFromUser(principal.getName());
    }
}
