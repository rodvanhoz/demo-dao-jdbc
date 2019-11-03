package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		Department department = departmentDao.findById(1);
		
		System.out.println("==== TEST 1: department findById() ====");
		System.out.println(department);
		
		System.out.println("\n==== TEST 2: department findAll() ====");
		List<Department> lista = departmentDao.findAll();
		
		for (Department s : lista) {
			System.out.println(s);
		}
		
		System.out.println("\n==== TEST 3: department insert() ====");
		Department newDepartment = new Department(null, "Music"); 
		departmentDao.insert(newDepartment);
		System.out.println("Inserido! Novo Id: " + newDepartment.getId());
		
		System.out.println("\n==== TEST 4: department update() ====");
		department = departmentDao.findById(12);
		department.setName("Cinema");
		departmentDao.update(department);
		System.out.println("Update completado!");
		
		System.out.println("\n==== TEST 5: department delete() ====");
		System.out.print("Informe o Id do Department: ");
		int idDeleta = sc.nextInt();
		
		departmentDao.deletById(idDeleta);
		
		System.out.println("Id Department " + idDeleta + " deletado com sucesso.");
		sc.close();
	}

}
