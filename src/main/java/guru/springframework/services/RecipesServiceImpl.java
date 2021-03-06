package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RecipesServiceImpl implements RecipesService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public List<Recipe> getRecipeList() {
        Iterable<Recipe> iterable = recipeRepository.findAll();
        List<Recipe> recipes = new ArrayList<Recipe>();
        iterable.forEach(recipes::add);
       return recipes;

    }

    @Override
    public void saveRecipesList(List<Recipe> recipes) {
        recipeRepository.saveAll(recipes);
    }
}
