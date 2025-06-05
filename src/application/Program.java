package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(1);
		System.out.println("=========== Test 1 - seller FindByID ========");
		System.out.println(seller);
		System.out.println("=========== Test 2 - seller FindByDepartment ========");
		Department department = new Department(2,null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj: list) {
			System.out.println(obj);
		}
		System.out.println("=========== Test 3 - seller FindAll ========");
		List<Seller> list1 = sellerDao.findAll();
		for(Seller obj: list1) {
			System.out.println(obj);
		}
		
		System.out.println("=========== Test 4 - seller Insert ========");
		Seller newSeller = new Seller(null,"Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("=========== Test 5 - seller Update ========");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("update completed!");
		
		System.out.println("=========== Test 5 - seller Delete ========");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("delete completed!");
	}

}
