package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== test 1: teste findById() ===");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("=== test 2: teste findByDepartmentId() ===");
		List<Seller> list = new ArrayList<>();
		Department dep = new Department(2, null);
		
		list = sellerDao.findbyDepartmentId(dep);
		
		for(Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("=== test 3: teste findAll() ===");
		List<Seller> lista = new ArrayList<>();
		
		lista = sellerDao.findAll();
		
		for(Seller obj: lista) {
			System.out.println(obj);
		}
		
		System.out.println("=== test 4: teste Insert ===");
		
		Seller newSeller = new Seller(null, "Leonam Braga", "leonam@gmail.com", new Date(), 5000.00, new Department(2, null));
		sellerDao.insert(newSeller);
		
		System.out.println("Iserted! new id = " + newSeller.getId());
		
		
		
		
	}

}
