package com.java.demo.bo;

import java.io.Serializable;

public class ProductDO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1359365580321863973L;
	private Integer shoeId;
	private String shoeName;
	private String shoeDescription;
	private String shoePolish;

	public ProductDO() {
	}

	public Integer getShoeId() {
		return shoeId;
	}

	public void setShoeId(Integer shoeId) {
		this.shoeId = shoeId;
	}

	public String getShoeName() {
		return shoeName;
	}

	public void setShoeName(String shoeName) {
		this.shoeName = shoeName;
	}

	public String getShoeDescription() {
		return shoeDescription;
	}

	public void setShoeDescription(String shoeDescription) {
		this.shoeDescription = shoeDescription;
	}

	public String getShoePolish() {
		return shoePolish;
	}

	public void setShoePolish(String shoePolish) {
		this.shoePolish = shoePolish;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ProductDO(Integer shoeId, String shoeName, String shoeDescription,
			String shoePolish) {
		super();
		this.shoeId = shoeId;
		this.shoeName = shoeName;
		this.shoeDescription = shoeDescription;
		this.shoePolish = shoePolish;
	}

	@Override
	public String toString() {
		return "ProductDO [shoeId=" + shoeId + ", shoeName=" + shoeName
				+ ", shoeDescription=" + shoeDescription + ", shoePolish=" + shoePolish + "]";
	}

}
