package guru.springframework.services;

import guru.springframework.domain.Recipe;

import java.util.List;

public interface RecipesService {

     List<Recipe> getRecipeList();

     void saveRecipesList(List<Recipe> recipes);
}
