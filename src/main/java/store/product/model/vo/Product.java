package store.product.model.vo;

public class Product implements java.io.Serializable{
	private static final long serialVersionUID = 7150592421829813504L;
	
	private String productId;
	private String productThumbnail;
	private int price;
	private String productSimpleExplan;
	private String productName;
	private String exposureYn;
	private String parentCategoryId;
	private String categoryName;
	private int productViewCount;
}
