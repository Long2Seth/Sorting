package co.istad.restapiwithmongdb.feature;


import co.istad.restapiwithmongdb.domain.Product;
import co.istad.restapiwithmongdb.feature.dto.ProductRequest;
import co.istad.restapiwithmongdb.feature.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

//    @GetMapping
//    public List<Product> getAllProducts() {
//        return productService.getAllProducts();
//    }


    @PostMapping
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById (@PathVariable String id){
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable String id, @RequestBody ProductRequest productRequest){
        productService.updateProduct(id, productRequest);
    }




//    @GetMapping
//    public Page<Product> getAllProducts(@RequestParam( defaultValue = "0") int pageNumber,
//                                        @RequestParam( defaultValue = "25") int pageSize){
//        return productService.getAllProducts(pageNumber, pageSize);
//    }

    @GetMapping
    public Page<Product> filterById(@RequestParam( defaultValue = "0") int pageNumber,
                                        @RequestParam( defaultValue = "25") int pageSize){
        return productService.getAllProducts(pageNumber, pageSize);
    }

}
