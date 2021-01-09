package pl.sda.finalapp.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    String productList(@RequestParam(value = "query", required = false) String query,
                       @RequestParam(value = "productType", required = false) ProductType productType,
                       Model model) {
        model.addAttribute("productsList", productService.findProducts(query, productType));
        model.addAttribute("searchText", query);
        model.addAttribute("productType", productType);
        model.addAttribute("productTypes", ProductType.values());
        return "productsPage";
    }


}
