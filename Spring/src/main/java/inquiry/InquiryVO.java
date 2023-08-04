package inquiry;

import java.sql.Date;

public class InquiryVO {
	private int inquiry_no, inquiry_room_no, member_no, admin_no;
	private String inquiry_message, read_or_not;
	private Date insert_date;
	public int getInquiry_no() {
		return inquiry_no;
	}
	public void setInquiry_no(int inquiry_no) {
		this.inquiry_no = inquiry_no;
	}
	public int getInquiry_room_no() {
		return inquiry_room_no;
	}
	public void setInquiry_room_no(int inquiry_room_no) {
		this.inquiry_room_no = inquiry_room_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public int getAdmin_no() {
		return admin_no;
	}
	public void setAdmin_no(int admin_no) {
		this.admin_no = admin_no;
	}
	public String getInquiry_message() {
		return inquiry_message;
	}
	public void setInquiry_message(String inquiry_message) {
		this.inquiry_message = inquiry_message;
	}
	public String getRead_or_not() {
		return read_or_not;
	}
	public void setRead_or_not(String read_or_not) {
		this.read_or_not = read_or_not;
	}
	public Date getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(Date insert_date) {
		this.insert_date = insert_date;
	}
	
}
