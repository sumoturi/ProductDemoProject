package com.java.demo.dao;
import com.java.demo.bo.ProductDO;

public class ProductDAO {

	private SessionFactory xeConSessionFactory = null;

	public void setXeConSessionFactory(SessionFactory xeConSessionFactory) {
		this.xeConSessionFactory = xeConSessionFactory;
	}

	public ProductDO getShoeByPK(Integer productPk) {
		ProductDO productDoObj = null;
		Session xeConSession = xeConSessionFactory.openSession();
		Transaction tx = null;
	      try {
		 tx = xeConSession.beginTransaction();
		 productDoObj = (ProductDO) xeConSession.get(ProductDO.class, productPk);
		 tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	    	  xeConSession.close(); 
	      }
		return deptDoObj;
		}
	
	 /* Method to CREATE a new shoe in the database */
	   public Integer addShoe(String shoeName, String shoeDesc, String shoePolish){
		  Session xeConSession = xeConSessionFactory.openSession();
		  Transaction tx = null;
	      Integer productID = null;
	      try {
	 		 tx = xeConSession.beginTransaction();
	         ProductDO shoe = new ProductDO(shoeName, shoeDesc, shoePolish);
	         deptID = (Integer) xeConSession.save(shoe);
	         tx.commit();
	      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		    	  xeConSession.close(); 
		      }
	      return productID;
	   }
	   
	   /* Method to UPDATE shoe name for a shoe */
	   public boolean updateShoe(Integer shoeId, String shoeName ){
		   Transaction tx = null;
		   boolean updated = false;
		  Session xeConSession = xeConSessionFactory.openSession();
		  try {
		 	tx = xeConSession.beginTransaction();
	         ProductDO shoe = (ProductDO) xeConSession.get(ProductDO.class, shoeId); 
	         shoe.setShoeName(shoeName);
	         xeConSession.update(shoe);
	         tx.commit();
	         updated = true;
	         xeConSession.close();
		  } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		    	  xeConSession.close(); 
		      }
	   return updated;
}
	   
	   /* Method to DELETE shoe */
	   public boolean updateDepartment(Integer shoeId){
		   Transaction tx = null;
		   boolean updated = false;
		  Session xeConSession = xeConSessionFactory.openSession();
		  try {
		 	tx = xeConSession.beginTransaction();
	         ProductDO shoe = (ProductDO) xeConSession.get(ProductDO.class, shoeId); 
	         xeConSession.delete(shoeId);
	         tx.commit();
	         updated = true;
	         xeConSession.close();
		  } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		    	  xeConSession.close(); 
		      }
	   return updated;
}
}
