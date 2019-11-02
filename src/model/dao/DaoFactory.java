package model.dao;

import model.dao.Impl.SellerDaoImplJDBC;

public class DaoFactory {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoImplJDBC();
	}
	
	

}
