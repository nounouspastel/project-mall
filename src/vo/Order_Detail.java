package vo;


public class Order_Detail {
	private String odseq; // 주문상세번호
	private String id; // 아이디
	private String pseq; // 상품번호
	private int quantity; // 수량
	private String deli;
	private String indate;
	private String image;
	private String name;
	private int totalprice;
	
	
	public Order_Detail(String id, String pseq, int quantity) {
		super();
		this.id = id;
		this.pseq = pseq;
		this.quantity = quantity;
	}
	public Order_Detail() {}
	
	public Order_Detail(String odseq, String deli, String name, int quantity, String pseq, int totalprice,
			String id, String indate) {
		this.odseq = odseq;
		this.name = name;
		this.quantity = quantity;
		this.deli = deli;
		this.pseq = pseq;
		this.totalprice = totalprice;
		this.id = id;
		this.indate = indate;
	}
	public Order_Detail(String odseq, String id, String pseq, String name, int quantity, int totalprice,
			String deli, String indate, String image) {
		this.odseq = odseq;
		this.id = id;
		this.pseq = pseq;
		this.name = name;
		this.quantity = quantity;
		this.totalprice = totalprice;
		this.deli = deli;
		this.indate = indate;
		this.image = image;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
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
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}
