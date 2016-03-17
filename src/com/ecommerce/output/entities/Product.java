package com.ecommerce.output.entities;

// default package
// Generated Mar 10, 2016 8:59:42 PM by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Product generated by hbm2java
 */
@Entity(name = "Item")
@Table(name = "PRODUCT", catalog = "Ankita")
public class Product implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 11L;
	private Integer productId;
	private String productName;
	private String manufacturer;
	private BigDecimal price;
	private Date expiryDtm;

	public Product() {
	}

	public Product(String productName, BigDecimal price, Date expiryDtm) {
		this.productName = productName;
		this.price = price;
		this.expiryDtm = expiryDtm;
	}

	public Product(String productName, String manufacturer, BigDecimal price, Date expiryDtm) {
		this.productName = productName;
		this.manufacturer = manufacturer;
		this.price = price;
		this.expiryDtm = expiryDtm;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "PRODUCT_ID", unique = true, nullable = false)
	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Column(name = "PRODUCT_NAME", nullable = false, length = 20)
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "MANUFACTURER", length = 32)
	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Column(name = "PRICE", nullable = false, precision = 10)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRY_DTM", nullable = false, length = 19)
	public Date getExpiryDtm() {
		return this.expiryDtm;
	}

	public void setExpiryDtm(Date expiryDtm) {
		this.expiryDtm = expiryDtm;
	}

}