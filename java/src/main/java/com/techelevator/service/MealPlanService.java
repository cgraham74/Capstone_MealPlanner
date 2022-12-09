package com.techelevator.service;

import com.techelevator.dto.MealPlannerDTO;
import com.techelevator.model.MealPlan;
import com.techelevator.repository.MealPlanRepository;
import com.techelevator.repository.RecipeIngredientRepository;
import com.techelevator.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class MealPlanService {

    @Autowired
    MealPlanRepository mealPlanRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RecipeIngredientRepository recipeIngredientRepository;

    public Long getUserId(String username) {
        return userRepository.getUserIdFromUsername(username);
    }

    @Transactional
    public void deleteMealPlanForUser(String username) {
        mealPlanRepository.deleteMealPlanFromUser(getUserId(username));
    }

    public void saveMealPlan(List<MealPlannerDTO> mealPlanList, String name) {

        for (MealPlannerDTO mealPlan : mealPlanList) {
            MealPlan incomingMealPlan = new MealPlan();
            incomingMealPlan.setMealplanid(mealPlan.getMealplanid());
            incomingMealPlan.setUser_id(getUserId(name));
            incomingMealPlan.setCategory(mealPlan.getCategory());
            incomingMealPlan.setDayofweek(mealPlan.getDayofweek());
            incomingMealPlan.setRecipename(mealPlan.getRecipename());
            mealPlanRepository.save(incomingMealPlan);
        }
    }

    public List<MealPlan> mealPlanListForUser(String name) {
        return mealPlanRepository.getMealPlanListFromUserId(getUserId(name));
    }


}
