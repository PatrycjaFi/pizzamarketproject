package pl.wszib.pizzamarketproject.data.entities;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "pizzas")
public class PizzaEntity {

   @Id
   @GeneratedValue
   @Column(name = "id")
   private Long id;
   @Column(name = "name")
   private String name;
   @Column(name = "price")
   private BigDecimal price;

   @ManyToMany
   @JoinTable(name = "pizza_ingredients",
           joinColumns = @JoinColumn(name = "pizza_id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
   private Set<IngredientEntity> ingredients;

   public Long getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public BigDecimal getPrice() {
      return price;
   }

   public Set<IngredientEntity> getIngredients() {
      return ingredients;
   }
}
