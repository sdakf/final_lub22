package pl.sda.finalapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/categories")
    public String categoriesPage(){
        return "categoriesPage";
    }

}
