package pl.wszib.pizzamarketproject.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wszib.pizzamarketproject.services.OrderService;

@Controller
@RequestMapping("admin")
public class AdminController {

    private final OrderService orderService;

    public AdminController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String showOrderPizzaAdminPage(Model model) {
        OrderService order = orderService;
        model.addAttribute("order", order);
        return "orderPizzaAdminPage";
    }
}
