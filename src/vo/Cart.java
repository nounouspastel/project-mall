package vo;


public class Cart {
	private int cartnum; // 주문번호(PK)<시퀀스+문자>
	private String overlap;
	private String id; // 아이디(FK)회원 아이디(member에서 받아옴)
	private String pseq; // 상품코드(FK)상품코드(product에서 받아옴)
	private String image; //이미지
	private String name; //상품이름
	private String kind; // category
	private int price_out; // 가격
	private int quantity; // 수량
	private int totalremain; //재고
	
	public Cart(String overlap, String id, String pseq, String image, String name, String kind,
				int price_out, int quantity) {
		super();
		this.overlap = overlap;
		this.id = id;
		this.pseq = pseq;
		this.image = image;
		this.name = name;
		this.kind = kind;
		this.price_out = price_out;
		this.quantity = quantity;
	}

	public Cart(String overlap, String id, String pseq, String name, String kind,
			int price_out, int quantity) {
	super();
	this.overlap = overlap;
	this.id = id;
	this.pseq = pseq;
	this.name = name;
	this.kind = kind;
	this.price_out = price_out;
	this.quantity = quantity;
}
	public Cart(String overlap, String id, String pseq, String image, String name, String kind, int price_out,
			int quantity, int totalremain) {
	this.overlap = overlap;
	this.id = id;
	this.pseq = pseq;
	this.image = image;
	this.name = name;
	this.kind = kind;
	this.price_out = price_out;
	this.quantity = quantity;
	this.totalremain = totalremain;
	}
	

	public String getOverlap() {
		return overlap;
	}

	public void setOverlap(String overlap) {
		this.overlap = overlap;
	}

	public Cart() {
	}


	public int getCartnum() {
		return cartnum;
	}
	public void setCartnum(int cartnum) {
		this.cartnum = cartnum;
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
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public int getPrice_out() {
		return price_out;
	}
	public void setPrice_out(int price_out) {
		this.price_out = price_out;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalremain() {
		return totalremain;
	}

	public void setTotalremain(int totalremain) {
		this.totalremain = totalremain;
	}


}
