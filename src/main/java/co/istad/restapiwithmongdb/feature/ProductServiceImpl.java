package co.istad.restapiwithmongdb.feature;

import co.istad.restapiwithmongdb.domain.Product;
import co.istad.restapiwithmongdb.feature.dto.ProductRequest;
import co.istad.restapiwithmongdb.feature.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();

    }



    @Override
    public void createProduct(ProductRequest productRequest) {

        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setName(productRequest.name());
        product.setDescription(productRequest.description());
        product.setPrice(productRequest.price());
        product.setQuantity(productRequest.quantity());
        productRepository.save(product);

    }

    @Override
    public ProductResponse getProductById(String id) {

        Product product = productRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id: " + id)
                );
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }

    @Override
    public void updateProduct(String id, ProductRequest productRequest) {

        Product product = productRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id: " + id)
                );

        product.setName(productRequest.name());
        product.setDescription(productRequest.description());
        product.setPrice(productRequest.price());
        product.setQuantity(productRequest.quantity());

        productRepository.save(product);
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {
//        Sort sort = Sort.by(Sort.Order.asc("name"), Sort.Order.asc("id"));
        Sort sort = Sort.by(Sort.Order.asc("name"));
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sort);
        return productRepository.findAll(pageRequest);
    }



}
