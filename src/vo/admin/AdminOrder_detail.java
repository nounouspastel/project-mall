package vo.admin;

import java.util.Date;

public class AdminOrder_detail {
	private String odseq;			// 주문번호
	private String id;				// 주문자ID
	private String pseq;			// 상품코드
	private int quantity;			// 수량
	private String deli;			// 배송정보
	private Date indate;			// 주문일
	private String name;			// 상품명
	private String kind;			// 상품종류
	private int price_in;			// 상품원가
	private int price_out;			// 상품판매가
	private String idname;			// 주문자 성명
	private String address1;		// 배송지
	private String address2;		// 배송지 상세정보
	private String phone;			// 전화번호
	private String vip;				// 회원등급
	
	
	public AdminOrder_detail(String odseq) {
		super();
		this.odseq = odseq;
	}
	public AdminOrder_detail() {
		// TODO Auto-generated constructor stub
	}
	public String getOdseq() {
		return odseq;
	}
	public void setOdseq(String odseq) {
		this.odseq = odseq;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPseq() {
		return pseq;
	}
	public void setPseq(String pseq) {
		this.pseq = pseq;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDeli() {
		return deli;
	}
	public void setDeli(String deli) {
		this.deli = deli;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getPrice_in() {
		return price_in;
	}
	public void setPrice_in(int price_in) {
		this.price_in = price_in;
	}
	public int getPrice_out() {
		return price_out;
	}
	public void setPrice_out(int price_out) {
		this.price_out = price_out;
	}
	public String getIdname() {
		return idname;
	}
	public void setIdname(String idname) {
		this.idname = idname;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getVip() {
		return vip;
	}
	public void setVip(String vip) {
		this.vip = vip;
	}
	
	
	
}
