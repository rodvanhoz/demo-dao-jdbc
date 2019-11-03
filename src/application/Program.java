package application;

import java.security.IdentityScope;
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
		Seller seller = sellerDao.findById(3);
		
		System.out.println("==== TEST 1: seller findById() ====");
		System.out.println(seller);
		
		
		System.out.println("\n==== TEST 2: seller findByDepartment() ====");
		Department dep = new Department(2, null);
		List<Seller> lista = sellerDao.findByDepartment(dep);
		
		for (Seller s : lista) {
			System.out.println(s);
		}
		
		System.out.println("\n==== TEST 3: seller findAll() ====");
		List<Seller> lista2 = sellerDao.findAll();
		
		for (Seller s : lista2) {
			System.out.println(s);
		}
		
		System.out.println("\n==== TEST 4: seller insert() ====");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new java.util.Date(), 4000.0, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserido! Novo Id: " + newSeller.getId());
		
		System.out.println("\n==== TEST 5: seller update() ====");
		seller = sellerDao.findById(2);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completado!");
		
		System.out.println("\n==== TEST 6: seller delete() ====");
		System.out.print("Informe o Id do Seller: ");
		int idDeleta = sc.nextInt();
		
		sellerDao.deletById(idDeleta);
		
		System.out.println("Id Seller " + idDeleta + " deletado com sucesso.");
		sc.close();
		
	}

}
