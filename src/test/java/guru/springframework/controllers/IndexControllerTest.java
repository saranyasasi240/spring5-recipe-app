package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class IndexControllerTest {
    @Mock
    private RecipeService recipeService;

    @Mock
    Model model;

    IndexController indexController;

    @Before
    public void setUP() throws Exception {
        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    public void getIndexPage() throws Exception {
        String viewName = indexController.getIndexPage(model);
        assertEquals("index", viewName);
        verify(recipeService,times(1)).getRecipes();
        verify(model,times(1)).addAttribute(eq("recipes"),anySet());
    }
}