package co.istad.restapiwithmongdb.feature;

import co.istad.restapiwithmongdb.domain.Product;
import co.istad.restapiwithmongdb.feature.dto.ProductRequest;
import co.istad.restapiwithmongdb.feature.dto.ProductResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    void createProduct(ProductRequest productRequest);

    ProductResponse getProductById(String id);

    void updateProduct(String id, ProductRequest productRequest);

//    Page<ProductResponse> getAllProducts(int pageNumber, int pageSize );
    Page<Product> getAllProducts(int pageNumber, int pageSize);

//    Page<Product> filterById(int pageNumber, int pageSize);


}
