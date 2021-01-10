package pl.sda.finalapp.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.finalapp.categories.CategoryService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    public List<ProductListDto> findProducts(String query, ProductType productType) {
        List<Product> products;
        if ((query == null || query.isBlank()) && productType == null) {
            products = productRepository.findAll();
        } else if (productType != null && (query != null && !query.isBlank()))  {
            products = productRepository.findByProductTypeAndTitle(query, productType);
        } else if (productType != null) {
            products = productRepository.findByProductType(productType);
        } else {
            products = productRepository.findByTitle(query);
        }
        return products.stream()
                .map(p -> createProductListDto(p))
                .collect(Collectors.toList());
    }

    private ProductListDto createProductListDto(Product p) {
        String categoryName = categoryService.findCategoryNameById(p.getCategoryId())
                .orElseGet(() -> createErrorText(p));
        return p.toDto(categoryName);
    }

    private String createErrorText(Product p) {
        return "BŁĄD " + p.getCategoryId();
    }

    public void addProduct(ProductDto dto) {
        Product product = Product.fromDto(dto);
        productRepository.save(product);
    }
}
