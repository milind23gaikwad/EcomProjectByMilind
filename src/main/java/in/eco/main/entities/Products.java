package in.eco.main.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Products {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
	  private String name;
	  
	  private Double price;
	  
	  @ManyToOne
	  @JoinColumn(name = "category_id")
	  private Category category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Products(Long id, String name, Double price, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
	}
	  
	  

}
