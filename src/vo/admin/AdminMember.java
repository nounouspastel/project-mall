package vo.admin;

import java.util.Date;

public class AdminMember {

	private String id;			//회원아이디 pk
	private String pwd;			//회원암호
	private String name;		//회원이름
	private String email;		//회원이메일
	private String zip_num;		//우편번호
	private String address1;	//주소
	private String address2;	//상세주소
	private String phone;		//전화번호
	private String vip;			//등급관리(등급별 구분 : g, s, b)
	private Date indate;		//가입일
	
	
//	public Member(String id, String pwd, String name, String email, String zip_num, String address1, String address2, String phone, String vip, Date indate) {
//		super();
//		this.id = id;
//		this.pwd = pwd;
//		this.name = name;
//		this.email = email;
//		this.zip_num = zip_num;
//		this.address1 = address1;
//		this.address2 = address2;
//		this.phone = phone;
//		this.vip = vip;
//		this.indate = indate;
//	}
	
	public AdminMember() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZip_num() {
		return zip_num;
	}
	public void setZip_num(String zip_num) {
		this.zip_num = zip_num;
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
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	
	

}
