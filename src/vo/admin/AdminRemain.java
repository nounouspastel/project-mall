package vo.admin;

import java.util.Date;

public class AdminRemain {

	private String order_num;		//주문번호(pk)
	private String pseq;	//상품코드 prudcut table
	private String name;    //productview에서 상품명 가져옴
	private String kind;	//productview에서 상품구분 가져옴
	private String deli;	//입고 / 출고 구분
	private int quantity;		//증가 수량
	private Date re_date;	//생성날짜
	
	public AdminRemain(String order_num, String pseq, String deli, int quantity, Date re_date) {
		super();
		this.order_num = order_num;
		this.pseq = pseq;
		this.deli = deli;
		this.quantity = quantity;
		this.re_date = re_date;
	}

	public AdminRemain(String order_num, String pseq, String name, String kind, String deli, int quantity, Date re_date) {
		super();
		this.order_num = order_num;
		this.pseq = pseq;
		this.name = name;
		this.kind = kind;
		this.deli = deli;
		this.quantity = quantity;
		this.re_date = re_date;
	}

	public AdminRemain() {
		// TODO Auto-generated constructor stub
	}

	public String getOrder_num() {
		return order_num;
	}


	public void setOrder_num(String order_num) {
		this.order_num = order_num;
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


	public Date getRe_date() {
		return re_date;
	}


	public void setRe_date(Date re_date) {
		this.re_date = re_date;
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

	public String getDeli() {
		return deli;
	}

	public void setDeli(String deli) {
		this.deli = deli;
	}

	

}
