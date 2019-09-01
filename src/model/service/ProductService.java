package model.service;

import java.util.ArrayList;
import java.util.List;

import model.entities.Product;

public class ProductService {
	
	public List<Product> findAll(){
		List<Product> list = new ArrayList<>();
		list.add(new Product(1, "Camisa", 50.0, 10));
		list.add(new Product(2, "Bermuda", 20.0, 15));
		list.add(new Product(3, "Calça", 90.0, 20));
		list.add(new Product(4, "Vestido", 80.0, 8));
		return list;
	}
	
}
