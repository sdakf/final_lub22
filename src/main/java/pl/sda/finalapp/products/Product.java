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

}
