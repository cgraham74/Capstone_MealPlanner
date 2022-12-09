package com.techelevator.controller;

import com.techelevator.dto.MealPlannerDTO;
import com.techelevator.model.MealPlan;
import com.techelevator.service.MealPlanService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/mealplan")
@EnableWebSecurity
@AllArgsConstructor
@Secured({"ROLE_USER", "ROLE_ADMIN"})
public class MealPlanController {

    private MealPlanService mealPlanService;

    //Returns meal plan based on token's username.
    @GetMapping()
    public List<MealPlan> mealPlanner(Principal principal) {
        return mealPlanService.mealPlanListForUser(principal.getName());
    }

    //Saves the meal plan to the database based on token's username.
    @PostMapping("/save")
    public void updateMealPlan(@RequestBody List<MealPlannerDTO> mealPlannerDTO, Principal principal){
        mealPlanService.saveMealPlan(mealPlannerDTO, principal.getName());
    }

    //Delete the current user's saved meal plan.
    @DeleteMapping("/delete")
    public void deleteUsersMealPlan(Principal principal) {
        mealPlanService.deleteMealPlanForUser(principal.getName());
    }


}
