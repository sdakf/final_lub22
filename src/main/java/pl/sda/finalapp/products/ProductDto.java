package pl.sda.finalapp.products;

import java.math.BigDecimal;

public class ProductDto {

    private Integer id;
    private String title;
    private String pictureUrl;
    private BigDecimal price;
    private ProductType productType;
    private Integer categoryId;

    public ProductDto(String title, String pictureUrl, BigDecimal price, ProductType productType, Integer categoryId) {
        this.title = title;
        this.pictureUrl = pictureUrl;
        this.price = price;
        this.productType = productType;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public Integer getCategoryId() {
        return categoryId;
    }
}
