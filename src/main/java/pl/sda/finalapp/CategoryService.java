package pl.sda.finalapp;

import org.springframework.stereotype.Service;

import java.util.List;
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
}
