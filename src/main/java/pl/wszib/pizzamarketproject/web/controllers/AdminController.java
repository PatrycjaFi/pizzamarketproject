package pl.wszib.pizzamarketproject.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wszib.pizzamarketproject.data.entities.OrderEntity;
import pl.wszib.pizzamarketproject.data.repositories.OrderRepository;
import pl.wszib.pizzamarketproject.services.OrderService;

import java.util.List;

@Controller
@RequestMapping("admin")
public class AdminController {

    private final OrderRepository orderRepository;
    private final OrderService orderService;


    public AdminController(OrderRepository orderRepository, OrderService orderService) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @GetMapping
    public String showOrderPizzaAdminPage(Model model) {
        List<OrderEntity> orders = orderRepository.findAll();
        model.addAttribute("orders", orders);
        return "orderPizzaAdminPage";
    }
}
