package store.main.model.vo;

import java.sql.Date;

public class Main implements java.io.Serializable {
	private static final long serialVersionUID = 5809504036915815855L;
	// 메인상품정보
	private String productThumbnail;
	private int price;
	private String productSimpleExplan;
	private String productName;
	private String productId;
	private String exposureYn;

	// 배너관련
	private String bannerImage;
	private int bannerPrority;
	private String bannerLink;
	private Date bannerStart;
	private Date bannerEnd;
	private int viewcount;

	public Main() {
		super();
	}

	public Main(String bannerImage, int bannerPrority, String bannerLink, Date bannerStart, Date bannerEnd,
			int viewcount) {
		this.bannerImage = bannerImage;
		this.bannerPrority = bannerPrority;
		this.bannerLink = bannerLink;
		this.bannerStart = bannerStart;
		this.bannerEnd = bannerEnd;
		this.viewcount = viewcount;
	}

	public Main(String productThumbnail, int price, String productSimpleExplan, String productName, String productId,
			String exposureYn) {
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

	public String getBannerImage() {
		return bannerImage;
	}

	public void setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
	}

	public int getBannerPrority() {
		return bannerPrority;
	}

	public void setBannerPrority(int bannerPrority) {
		this.bannerPrority = bannerPrority;
	}

	public String getBannerLink() {
		return bannerLink;
	}

	public void setBannerLink(String bannerLink) {
		this.bannerLink = bannerLink;
	}

	public Date getBannerStart() {
		return bannerStart;
	}

	public void setBannerStart(Date bannerStart) {
		this.bannerStart = bannerStart;
	}

	public Date getBannerEnd() {
		return bannerEnd;
	}

	public void setBannerEnd(Date bannerEnd) {
		this.bannerEnd = bannerEnd;
	}

	public int getViewcount() {
		return viewcount;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Main [productThumbnail=" + productThumbnail + ", price=" + price + ", productSimpleExplan="
				+ productSimpleExplan + ", productName=" + productName + ", productId=" + productId + ", exposureYn="
				+ exposureYn + ", bannerImage=" + bannerImage + ", bannerPrority=" + bannerPrority + ", bannerLink="
				+ bannerLink + ", bannerStart=" + bannerStart + ", bannerEnd=" + bannerEnd + ", viewcount=" + viewcount
				+ "]";
	}
	
}
