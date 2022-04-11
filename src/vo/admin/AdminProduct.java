package vo.admin;

import java.util.Date;

public class AdminProduct {
	private String pseq;            //임의로 생성 pk
	private String name;			//상품명 (중복안되게 하자)
	private String kind;			//상품종류(카테고리 의자:c 테이블:t 텐트 : p)
	private int price_in;			//원가
	private int price_out;			//판매가
	private String content;			//상품내용
	private String image;			//디폴트 이미지는 “이미지 준비 중입니다”로 생성해볼것
	private int quantity;
	private Date indate;			//상품등록일
	
	
	public AdminProduct(String pseq, String name, String kind, int price_in, int price_out, String content, String image, int quantity, Date indate) {
		super();
		this.pseq = pseq;
		this.name = name;
		this.kind = kind;
		this.price_in = price_in;
		this.price_out = price_out;
		this.content = content;
		this.image = image;
		this.quantity = quantity;
		this.indate = indate;
	}

	public AdminProduct(String pseq, String name, String kind, int price_in, int price_out, String content, String image, Date indate) {
		super();
		this.pseq = pseq;
		this.name = name;
		this.kind = kind;
		this.price_in = price_in;
		this.price_out = price_out;
		this.content = content;
		this.image = image;
		this.indate = indate;
	}

	public AdminProduct() {
		// TODO Auto-generated constructor stub
	}

	public String getPseq() {
		return pseq;
	}


	public void setPseq(String pseq) {
		this.pseq = pseq;
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


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Date getIndate() {
		return indate;
	}


	public void setIndate(Date indate) {
		this.indate = indate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	
}
