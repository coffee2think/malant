package store.main.model.vo;

import java.sql.Date;

public class MainProduct implements java.io.Serializable {
	private static final long serialVersionUID = 5809504036915815855L;
	// 메인상품정보
	private String productThumbnail;
	private int price;
	private String productSimpleExplan;
	private String productName;
	private String productId;
	private String exposureYn;
	
	
	public MainProduct() {
		super();
	}


	public MainProduct(String productThumbnail, int price, String productSimpleExplan, String productName,
			String productId, String exposureYn) {
		super();
		this.productThumbnail = productThumbnail;
		this.price = price;
		this.productSimpleExplan = productSimpleExplan;
		this.productName = productName;
		this.productId = productId;
		this.exposureYn = exposureYn;
	}


	public String getProductThumbnail() {
		return productThumbnail;
	}


	public void setProductThumbnail(String productThumbnail) {
		this.productThumbnail = productThumbnail;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getProductSimpleExplan() {
		return productSimpleExplan;
	}


	public void setProductSimpleExplan(String productSimpleExplan) {
		this.productSimpleExplan = productSimpleExplan;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getExposureYn() {
		return exposureYn;
	}


	public void setExposureYn(String exposureYn) {
		this.exposureYn = exposureYn;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "MainProduct [productThumbnail=" + productThumbnail + ", price=" + price + ", productSimpleExplan="
				+ productSimpleExplan + ", productName=" + productName + ", productId=" + productId + ", exposureYn="
				+ exposureYn + "]";
	}
	
	

}
