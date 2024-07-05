package com.webpage.quetortas.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Dessert {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dessertId;
	
	@NotNull
	@Size(min = 3, max = 35)
	@Column(name = "dessert_name", nullable=false)
	private String dessertName;
	
	@NotNull
	@Size(min = 3, max = 150)
	@Column(name = "dessert_description", nullable=false)
	private String dessertDescription;
	
	@NotNull
    @PositiveOrZero
    @Column(name = "cantidad_actual", nullable = false)
	private double dessertPrice;
	
	@NotNull
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id",referencedColumnName = "id", nullable = false, unique = true)
	private Category dessertCategory;
	
	public Dessert(int dessertId, String dessertName, String dessertDescription, double dessertPrice,
			Category dessertCategory) {
		super();
		this.dessertId = dessertId;
		this.dessertName = dessertName;
		this.dessertDescription = dessertDescription;
		this.dessertPrice = dessertPrice;
		this.dessertCategory = dessertCategory;
	}
	
	public Dessert(String dessertName, String dessertDescription, double dessertPrice, Category dessertCategory) {
		super();
		this.dessertName = dessertName;
		this.dessertDescription = dessertDescription;
		this.dessertPrice = dessertPrice;
		this.dessertCategory = dessertCategory;
	}

	@Override
	public String toString() {
		return "Dessert [dessertId=" + dessertId + ", dessertName=" + dessertName + ", dessertDescription="
				+ dessertDescription + ", dessertPrice=" + dessertPrice + ", dessertCategory=" + dessertCategory + "]";
	}
	
}
