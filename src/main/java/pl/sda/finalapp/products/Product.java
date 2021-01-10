package pl.sda.finalapp.products;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String title;
    private String pictureUrl;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    private Integer categoryId;

    public Product() {

    }

    public Product(String title, String pictureUrl, BigDecimal price, ProductType productType, Integer categoryId) {
        this.title = title;
        this.pictureUrl = pictureUrl;
        this.price = price;
        this.productType = productType;
        this.categoryId = categoryId;
    }

    public ProductListDto toDto(String categoryName) {
        return new ProductListDto(this.id,
                this.title,
                this.pictureUrl,
                this.price,
                this.productType,
                categoryName);
    }

    public static Product fromDto(ProductDto dto){
        Product product = new Product();
        product.title = dto.getTitle();
        product.pictureUrl = dto.getPictureUrl();
        product.price = dto.getPrice();
        product.productType = dto.getProductType();
        product.categoryId = dto.getCategoryId();
        return product;
    }

    public Integer getCategoryId() {
        return categoryId;
    }
}
