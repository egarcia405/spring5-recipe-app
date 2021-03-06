package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/recipes")
public class RecipeController {
    @Autowired
    private RecipesService recipesService;

    public RecipeController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @RequestMapping({"", "/", "/index"})
    public String listRecipes(Model model){
        for(Recipe recipe : recipesService.getRecipeList()){
            System.out.println(recipe.getCategories());
            System.out.println(recipe.getPrepTime());
            System.out.println(recipe.getCookTime());
        }
        model.addAttribute("recipes", recipesService.getRecipeList());
        return "recipes/index";
    }
}
