package com.disney.cast.platform.vacationplanner.ui.snow.model.category;

import java.util.List;

public class CategoryRecordEntity {

	private boolean active;
	private String name;
	private List<Product> products;
	
	
	
	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public List<Product> getProducts() {
		return products;
	}



	public void setProducts(List<Product> products) {
		this.products = products;
	}



	public static class Product {
		private String name;
		private boolean active;
		private String considerations;
		private String description;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public boolean isActive() {
			return active;
		}
		public void setActive(boolean active) {
			this.active = active;
		}
		public String getConsiderations() {
			return considerations;
		}
		public void setConsiderations(String considerations) {
			this.considerations = considerations;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		
	}
}
