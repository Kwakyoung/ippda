package review;

import goods.GoodsVO;

public class ReviewVO extends GoodsVO {

	private int review_no, goods_no, store_no;
	private float rating;
	private String content, member_no;
	private String insert_date;
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public int getGoods_no() {
		return goods_no;
	}
	public void setGoods_no(int goods_no) {
		this.goods_no = goods_no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(String insert_date) {
		this.insert_date = insert_date;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public int getStore_no() {
		return store_no;
	}
	public void setStore_no(int store_no) {
		this.store_no = store_no;
	}
	public String getMember_no() {
		return member_no;
	}
	public void setMember_no(String member_no) {
		this.member_no = member_no;
	}
	
	private String
	member_id,
	member_pw,
	member_gender,
	member_email,
	member_nickname,
	member_phone,
	member_address,
	member_bank,
	member_bank_no,
	member_profile_image,
	member_birthday,
	member_name,
	member_create,
	member_sub_address,
	popup;
	
	
	private int  member_money;

	
	
	public String getMember_id() {
		return member_id;
	}


	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}


	public String getMember_pw() {
		return member_pw;
	}


	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}


	public String getMember_gender() {
		return member_gender;
	}


	public void setMember_gender(String member_gender) {
		this.member_gender = member_gender;
	}


	public String getMember_email() {
		return member_email;
	}


	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}


	public String getMember_nickname() {
		return member_nickname;
	}


	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}


	public String getMember_phone() {
		return member_phone;
	}


	public void setMember_phone(String member_phone) {
		this.member_phone = member_phone;
	}


	public String getMember_address() {
		return member_address;
	}


	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}


	public String getMember_bank() {
		return member_bank;
	}


	public void setMember_bank(String member_bank) {
		this.member_bank = member_bank;
	}


	public String getMember_bank_no() {
		return member_bank_no;
	}


	public void setMember_bank_no(String member_bank_no) {
		this.member_bank_no = member_bank_no;
	}


	public String getMember_profile_image() {
		return member_profile_image;
	}


	public void setMember_profile_image(String member_profile_image) {
		this.member_profile_image = member_profile_image;
	}


	public String getMember_birthday() {
		return member_birthday;
	}


	public void setMember_birthday(String member_birthday) {
		this.member_birthday = member_birthday;
	}


	public String getMember_name() {
		return member_name;
	}


	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}


	public String getMember_create() {
		return member_create;
	}


	public void setMember_create(String member_create) {
		this.member_create = member_create;
	}


	public String getMember_sub_address() {
		return member_sub_address;
	}


	public void setMember_sub_address(String member_sub_address) {
		this.member_sub_address = member_sub_address;
	}


	public String getPopup() {
		return popup;
	}


	public void setPopup(String popup) {
		this.popup = popup;
	}



	public int getMember_money() {
		return member_money;
	}


	public void setMember_money(int member_money) {
		this.member_money = member_money;
	}
	
}
