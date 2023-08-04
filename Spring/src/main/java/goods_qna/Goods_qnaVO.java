package goods_qna;

import java.sql.Date;

public class Goods_qnaVO {
	private int qna_no, member_no, goods_option_no, goods_no, store_no, qna_type, qna_option;
	private String qna_writer, qna_title, qna_context, qna_image, qna_secret;
	private Date insert_date;
	public int getQna_no() {
		return qna_no;
	}
	public void setQna_no(int qna_no) {
		this.qna_no = qna_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public int getGoods_option_no() {
		return goods_option_no;
	}
	public void setGoods_option_no(int goods_option_no) {
		this.goods_option_no = goods_option_no;
	}
	public int getGoods_no() {
		return goods_no;
	}
	public void setGoods_no(int goods_no) {
		this.goods_no = goods_no;
	}
	public int getStore_no() {
		return store_no;
	}
	public void setStore_no(int store_no) {
		this.store_no = store_no;
	}
	public int getQna_type() {
		return qna_type;
	}
	public void setQna_type(int qna_type) {
		this.qna_type = qna_type;
	}
	public int getQna_option() {
		return qna_option;
	}
	public void setQna_option(int qna_option) {
		this.qna_option = qna_option;
	}
	public String getQna_writer() {
		return qna_writer;
	}
	public void setQna_writer(String qna_writer) {
		this.qna_writer = qna_writer;
	}
	public String getQna_title() {
		return qna_title;
	}
	public void setQna_title(String qna_title) {
		this.qna_title = qna_title;
	}
	public String getQna_context() {
		return qna_context;
	}
	public void setQna_context(String qna_context) {
		this.qna_context = qna_context;
	}
	public String getQna_image() {
		return qna_image;
	}
	public void setQna_image(String qna_image) {
		this.qna_image = qna_image;
	}
	public String getQna_secret() {
		return qna_secret;
	}
	public void setQna_secret(String qna_secret) {
		this.qna_secret = qna_secret;
	}
	public Date getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(Date insert_date) {
		this.insert_date = insert_date;
	}
	
}
