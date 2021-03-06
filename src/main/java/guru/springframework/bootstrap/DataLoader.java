package guru.springframework.bootstrap;

import guru.springframework.domain.Category;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import guru.springframework.services.RecipesService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataLoader implements CommandLineRunner {


    private final RecipesService recipesService;

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public DataLoader(RecipesService recipesService, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {

         this.recipesService = recipesService;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = recipesService.getRecipeList().size();
        if(count == 0){
            loadData();
        }
    }

    private void loadData(){

        List<Recipe> recipeList = new ArrayList<>();
        Recipe guacRecipe = new Recipe();
        Set guacCategories = new HashSet();

        Optional<Category> guacCategoryOptional = categoryRepository.findByDescription("Mexican");
        guacRecipe.setCookTime(10);
        guacRecipe.setPrepTime(30);
        Category cat = guacCategoryOptional.get();

        guacCategories.add(cat);
        guacRecipe.setCategories(guacCategories);
        recipeList.add(guacRecipe);
        recipesService.saveRecipesList(recipeList);


//        System.out.println("END "+guacRecipe.getCategories().size());
//        for (Category cate: guacRecipe.getCategories()) {
//            System.out.println(cate.getDescription());
//        }
    }

}
