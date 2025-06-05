package model.dao;

import java.util.List;

import model.entities.Seller;

public interface SellerDao {
	void insert(Seller d);
	void update(Seller d);
	void deleteById(Seller id);
	Seller findById(Seller id);
	List<Seller> findAll();
}
