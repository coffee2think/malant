package store.order.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class ProductOrder implements Serializable {

	private static final long serialVersionUID = 4764640135713951068L;
	
	private String orderId;
	private String productId;
	private String userNo;
	private int quantity;
	private Date orderDate;
	private String buyerName;
	private String buyerContact;
	private String recipient;
	private String recipientContact;
	private int price;
	private int deliveryChage;
	private int totalPrice;
	
	//주소 받는 부분
	private String shippingAddressName;
	private String codePostal;
	private String deliveryAddress;
	private String deliveryAddress2;
	private String deliveryNote;
	
	//결제 받는 부분
	private String paymentType;
	private String orderProgress;
	private String paymentStatus;
	
	public ProductOrder() {
		super();
	}

	public ProductOrder(String orderId, String productId, String userNo, int quantity, Date orderDate, String buyerName,
			String buyerContact, String recipient, String recipientContact, int price, int deliveryChage,
			int totalPrice, String shippingAddressName, String codePostal, String deliveryAddress,
			String deliveryAddress2, String deliveryNote, String paymentType, String orderProgress,
			String paymentStatus) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.userNo = userNo;
		this.quantity = quantity;
		this.orderDate = orderDate;
		this.buyerName = buyerName;
		this.buyerContact = buyerContact;
		this.recipient = recipient;
		this.recipientContact = recipientContact;
		this.price = price;
		this.deliveryChage = deliveryChage;
		this.totalPrice = totalPrice;
		this.shippingAddressName = shippingAddressName;
		this.codePostal = codePostal;
		this.deliveryAddress = deliveryAddress;
		this.deliveryAddress2 = deliveryAddress2;
		this.deliveryNote = deliveryNote;
		this.paymentType = paymentType;
		this.orderProgress = orderProgress;
		this.paymentStatus = paymentStatus;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerContact() {
		return buyerContact;
	}

	public void setBuyerContact(String buyerContact) {
		this.buyerContact = buyerContact;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getRecipientContact() {
		return recipientContact;
	}

	public void setRecipientContact(String recipientContact) {
		this.recipientContact = recipientContact;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDeliveryChage() {
		return deliveryChage;
	}

	public void setDeliveryChage(int deliveryChage) {
		this.deliveryChage = deliveryChage;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getShippingAddressName() {
		return shippingAddressName;
	}

	public void setShippingAddressName(String shippingAddressName) {
		this.shippingAddressName = shippingAddressName;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getDeliveryAddress2() {
		return deliveryAddress2;
	}

	public void setDeliveryAddress2(String deliveryAddress2) {
		this.deliveryAddress2 = deliveryAddress2;
	}

	public String getDeliveryNote() {
		return deliveryNote;
	}

	public void setDeliveryNote(String deliveryNote) {
		this.deliveryNote = deliveryNote;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getOrderProgress() {
		return orderProgress;
	}

	public void setOrderProgress(String orderProgress) {
		this.orderProgress = orderProgress;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ProductOrder [orderId=" + orderId + ", productId=" + productId + ", userNo=" + userNo + ", quantity="
				+ quantity + ", orderDate=" + orderDate + ", buyerName=" + buyerName + ", buyerContact=" + buyerContact
				+ ", recipient=" + recipient + ", recipientContact=" + recipientContact + ", price=" + price
				+ ", deliveryChage=" + deliveryChage + ", totalPrice=" + totalPrice + ", shippingAddressName="
				+ shippingAddressName + ", codePostal=" + codePostal + ", deliveryAddress=" + deliveryAddress
				+ ", deliveryAddress2=" + deliveryAddress2 + ", deliveryNote=" + deliveryNote + ", paymentType="
				+ paymentType + ", orderProgress=" + orderProgress + ", paymentStatus=" + paymentStatus + "]";
	}
	
	
	
	
	
}
