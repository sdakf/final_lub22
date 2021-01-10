package pl.sda.finalapp;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.finalapp.categories.CategoryService;
import pl.sda.finalapp.products.Product;
import pl.sda.finalapp.products.ProductRepository;
import pl.sda.finalapp.products.ProductType;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataSeed implements InitializingBean {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    @Override
    public void afterPropertiesSet() {
        if (productRepository.count() > 0) {
            return;
        }
        List<Integer> categoriesIds = categoryService.findCategories("").stream()
                .map(c -> c.getId())
                .collect(Collectors.toList());
        for (int i = 0; i < 10; i++) {
            Product product = new Product("title" + i,
                    "pictureUrl" + i,
                    BigDecimal.valueOf(i),
                    ProductType.values()[i % 3],
                    categoriesIds.get(Math.min(i, categoriesIds.size() - 1)));
            productRepository.save(product);
        }
    }
}
