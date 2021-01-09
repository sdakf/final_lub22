package pl.sda.finalapp.categories;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private CategoryDao categoryDao = CategoryDao.getInstance();

    public List<CategoryDto> findCategories(String searchText) {
        List<CategoryDto> dtos = categoryDao.getCategoryList().stream()
                .map(c -> c.toDto())
                .collect(Collectors.toList());

        for (CategoryDto dto : dtos) {
            if (dto.getCategoryName().equals(searchText)) {
                dto.applySelected(true);
                openAllParents(dto.getParentId(), dtos);
            }
        }
        return dtos;
    }

    private void openAllParents(Integer parentId, List<CategoryDto> potentialParents) {
        if (parentId == null) {
            return;
        }
        potentialParents.stream()
                .filter(dto -> parentId.equals(dto.getId()))
                .forEach(dto -> {
                    dto.applyOpen(true);
                    openAllParents(dto.getParentId(), potentialParents);
                });
    }

    public void addCategory(String categoryName, Integer parentId) {
        categoryDao.addCategory(categoryName, parentId);
    }

    public void changeParent(Integer newParent, Integer categoryId) {
        if (newParent == null) {
            Category categoryById = categoryDao.findCategoryById(categoryId)
                    .orElseThrow();
            categoryById.changeParent(newParent);
        } else {
            List<Category> daoCategoryList = categoryDao.getCategoryList();

            boolean isNewParentExists = daoCategoryList.stream()
                    .anyMatch(c -> newParent.equals(c.getId()));

            if (isNewParentExists) {
                Category category = daoCategoryList.stream()
                        .filter(c -> categoryId.equals(c.getId()))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException());

                List<Category> categoriesWithGivenParentId = daoCategoryList.stream()
                        .filter(c -> categoryId.equals(c.getParentId()))
                        .collect(Collectors.toList());

                categoriesWithGivenParentId.forEach(c -> c.changeParent(category.getParentId()));

                category.changeParent(newParent);
            }
        }
    }

    public Optional<String> findCategoryNameById(Integer categoryId) {
        return categoryDao.findCategoryById(categoryId)
                .map(c -> c.getCategoryName());
    }
}
