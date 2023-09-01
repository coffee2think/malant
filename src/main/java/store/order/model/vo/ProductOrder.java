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
}
