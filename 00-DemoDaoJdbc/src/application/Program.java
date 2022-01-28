package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== test 1: seller findById() ===");
		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println("=== test 2: seller findByDepartmentId() ===");
		List<Seller> list = new ArrayList<>();
		Department dep = new Department(2, null);

		list = sellerDao.findbyDepartmentId(dep);

		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("=== test 3: seller findAll() ===");
		List<Seller> lista = new ArrayList<>();

		lista = sellerDao.findAll();

		for (Seller obj : lista) {
			System.out.println(obj);
		}

		System.out.println("=== test 4: seller Insert() ===");

		Seller newSeller = new Seller(null, "Leonam Braga", "leonam@gmail.com", new Date(), 5000.00,
				new Department(2, null));
		sellerDao.insert(newSeller);

		System.out.println("Iserted! new id = " + newSeller.getId());

		System.out.println("=== test 5: seller upDate() ===");
		seller = sellerDao.findById(1);
		seller.setName("Leonam Braga");
		sellerDao.update(seller);
		System.out.println("Update completo!");

		System.out.println("=== test 6: seller delete() ===");
		System.out.print("Escolha um id para apagar: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete complete!");

		// =================================================================== COMEÇANDO TESTES PARA DEPARTAMENTO ===========================================================================

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("=== test 1: Department findById() ===");
		Department department = departmentDao.findById(3);

		System.out.println(department);

		System.out.println("=== test 2: Department findAll() ===");
		List<Department> listDepartment = new ArrayList<>();

		listDepartment = departmentDao.findAll();

		for (Department obj : listDepartment) {
			System.out.println(obj);
		}

		System.out.println("=== test 4: Department Insert() ===");

		Department newDepartment = new Department(null, "Brinquedos");
		departmentDao.insert(newDepartment);

		System.out.println("Iserted! new id = " + newDepartment.getId());
		
		System.out.println("=== test 5: teste upDate() ===");
		department = departmentDao.findById(7);
		department.setName("Moveis");
		departmentDao.update(department);
		System.out.println("Update completo!");
		
		System.out.println("=== test 6: teste delete() ===");
		System.out.print("Escolha um id para apagar: ");
		int id2 = sc.nextInt();
		departmentDao.deleteById(id2);
		System.out.println("Delete complete!");

		sc.close();

	}

}
