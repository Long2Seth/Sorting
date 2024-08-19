package co.istad.restapiwithmongdb.domain;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Setter
@Getter
public class Product {
    String id;
    String name ;
    String description;
    double price;
    int quantity;

}
