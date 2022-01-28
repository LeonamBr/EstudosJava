package model.dao;

public class DaoFactory {
	
	public static SellerDao createSellerdao() {
		return new SellerDaoJDBC();
	}

}
