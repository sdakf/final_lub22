package pl.sda.finalapp.categories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryServiceTest {

    private CategoryService categoryService =  new CategoryService();

    @Test
    void shouldChangeParent(){
    //given
        List<Category> categoryList = CategoryDao.getInstance().getCategoryList();
    //when
        categoryService.changeParent(1, 5);
        categoryService.changeParent(7, 6);
    //then
        Category categoryFifth = findCategory(categoryList, 5);
        Category categorySixth = findCategory(categoryList, 6);
        assertEquals(categoryFifth.getParentId(), 1);
        assertEquals(categorySixth.getParentId(), 7);
    }

    @Test
    void shouldChangeParentOnNull(){
        //given
        List<Category> categoryList = CategoryDao.getInstance().getCategoryList();
        //when
        categoryService.changeParent(null, 5);
        //then
        Category categoryFifth = findCategory(categoryList, 5);
        assertEquals(categoryFifth.getParentId(), null);

    }


    private Category findCategory(List<Category> categoryList, int categoryId) {
        return categoryList.stream()
                .filter(c -> c.getId().equals(categoryId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nie znaleziono kategorii o id " + categoryId));
    }
}
