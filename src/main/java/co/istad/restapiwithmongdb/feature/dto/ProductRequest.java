package co.istad.restapiwithmongdb.feature.dto;

public record ProductRequest(

            String name,
            String description,
            double price,
            int quantity
) {
}
