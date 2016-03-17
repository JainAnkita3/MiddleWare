package com.ecommerce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ecommerce.output.entities.Product;
import com.ecommerce.util.EcommerceUtil;

public class EcommerceDAO extends EcommerceUtil {

	Transaction txn;
	Session session;
	SessionFactory sf;
	List<Integer> idList = new ArrayList<>();

	public EcommerceDAO() {
		System.out.println("Construtor");
		addProduct();
		getProduct();
		updateProduct();
		deleteProduct();

		if (!(EcommerceUtil.getSessionFactory().isClosed())) {
			EcommerceUtil.getSessionFactory().close();
			System.out.println("Closing Session Factory");
		}
	}

	/**
	 * This method will Add the records in table
	 */
	private void addProduct() {
		System.out.println(" Adding Items in Product Table");
		Product item1 = new Product();
		Product item2 = new Product();
		Product item3 = new Product();
		Product item4 = new Product();
		Product item5 = new Product();
		Product item6 = new Product();
		Product item7 = new Product();

		List<Integer> itemId = new ArrayList<Integer>();
		try {
			session = createSession();
			txn = session.beginTransaction();

			item1.setProductName("Notebook");
			item1.setManufacturer("abc");
			item1.setPrice(new BigDecimal("2.99"));
			item1.setExpiryDtm(new java.util.Date());
			itemId.add((Integer) session.save(item1));

			item2.setProductName("SketchPen");
			item2.setManufacturer("abc");
			item2.setPrice(new BigDecimal("1.99"));
			item2.setExpiryDtm(new java.util.Date());
			session.save(item2);
			itemId.add((Integer) session.save(item1));

			item3.setProductName("Compass");
			item3.setManufacturer("abc");
			item3.setPrice(new BigDecimal("6.99"));
			item3.setExpiryDtm(new java.util.Date());
			session.save(item3);
			itemId.add((Integer) session.save(item1));

			item4.setProductName("Ball Pen");
			item4.setManufacturer("abc");
			item4.setPrice(new BigDecimal("2.99"));
			item4.setExpiryDtm(new java.util.Date());
			session.save(item4);
			itemId.add((Integer) session.save(item1));

			item5.setProductName("Pencil");
			item5.setManufacturer("Natraj");
			item5.setPrice(new BigDecimal("3.99"));
			item5.setExpiryDtm(new java.util.Date());
			session.save(item5);
			itemId.add((Integer) session.save(item1));

			item6.setProductName("White Board");
			item6.setManufacturer("abc");
			item6.setPrice(new BigDecimal("13.99"));
			item6.setExpiryDtm(new java.util.Date());
			session.save(item6);
			itemId.add((Integer) session.save(item1));

			item7.setProductName("Black Board");
			item7.setManufacturer("xyz");
			item7.setPrice(new BigDecimal("13.99"));
			item7.setExpiryDtm(new java.util.Date());
			session.save(item7);
			itemId.add((Integer) session.save(item1));

			session.flush();
			txn.commit();

			System.out.println("Records Inserted successfully" + itemId);

		} catch (HibernateException e) {

			System.out.println("Caught Exception");
			txn.rollback();
			e.printStackTrace();

		} finally {
			closeSession();
		}

	}

	/**
	 * This method will the read records from table
	 */
	private void getProduct() {
		session = createSession();
		txn = session.beginTransaction();

		Query hqlQuery = session.createQuery("from Item");
		List<Product> items = hqlQuery.list();
		for (Product it : items) {
			System.out.println("Product Id : '" + it.getProductId() + "', Product Name : '" + it.getProductName()
					+ "', Price : '" + it.getPrice() + "', Manufacturer : '" + it.getManufacturer() + "', Expiry Date '"
					+ it.getExpiryDtm());
		}
		txn.commit();
		closeSession();
	}

	/**
	 * This method will update the records of table
	 */
	private void updateProduct() {
		session = createSession();
		txn = session.beginTransaction();
		Product item = new Product();

		idList = doSqlQuery("Compass");
		for (Integer id : idList) {
			item = session.get(Product.class, id);
			item.setPrice(new BigDecimal("7.99"));
			session.saveOrUpdate(item);
		}

		System.out.println("Price Updated Succesfully, now it : '" + item.getPrice() + "$'");

		txn.commit();
		closeSession();
	}

	/**
	 * This method will Delete the records from table
	 */
	private void deleteProduct() {
		session = createSession();
		txn = session.beginTransaction();

		Product it = session.load(Product.class, 40);
		session.delete(it);
		System.out.println("Record Deleted Succesfully");

		txn.commit();
		closeSession();
	}

	private List<Integer> doSqlQuery(String productName) {

		String sql = "SELECT PRODUCT_ID FROM PRODUCT WHERE PRODUCT_NAME = '%productName%'";
		System.out.println("   ********* " + sql);
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		List<Integer> idList = sqlQuery.list();
		return idList;

	}
}
