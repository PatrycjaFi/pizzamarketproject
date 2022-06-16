package pl.wszib.pizzamarketproject.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.wszib.pizzamarketproject.data.entities.OrderAddressEntity;
import pl.wszib.pizzamarketproject.data.entities.OrderEntity;
import pl.wszib.pizzamarketproject.data.entities.PizzaEntity;
import pl.wszib.pizzamarketproject.data.repositories.OrderRepository;
import pl.wszib.pizzamarketproject.data.repositories.PizzaRepository;
import pl.wszib.pizzamarketproject.web.mappers.OrderAddressMapper;
import pl.wszib.pizzamarketproject.web.models.OrderAddressModel;

import javax.persistence.EntityNotFoundException;

@Service
public class OrderService {

    private final PizzaRepository pizzaRepository;
    private final OrderRepository orderRepository;

    public OrderService(PizzaRepository pizzaRepository, OrderRepository orderRepository) {
        this.pizzaRepository = pizzaRepository;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public void saveOrder(Long pizzaId, OrderAddressModel orderAddressModel) {
    PizzaEntity pizzaEntity = pizzaRepository.findById(pizzaId).orElseThrow(EntityNotFoundException::new);

        OrderAddressEntity orderAddressEntity = OrderAddressMapper.toEntity(orderAddressModel);

        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setPizzaName(pizzaEntity.getName());
        orderEntity.setOrderAddress(orderAddressEntity);

        orderRepository.save(orderEntity);
    }
}
