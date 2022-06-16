package pl.wszib.pizzamarketproject.web.mappers;

import pl.wszib.pizzamarketproject.data.entities.OrderAddressEntity;
import pl.wszib.pizzamarketproject.web.models.OrderAddressModel;

public class OrderAddressMapper {
    public static OrderAddressEntity toEntity(OrderAddressModel model) {
        OrderAddressEntity entity = new OrderAddressEntity();
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setStreet(model.getStreet());
        entity.setPostalCode(model.getPostalCode());
        entity.setCity(model.getCity());
        return entity;
    }
}
