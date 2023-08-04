package inquiry_room;

import java.sql.Date;

public class Inquiry_roomVO {
	private int inquiry_room_no, member_no;
	private Date insert_date;
	
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
	public Date getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(Date insert_date) {
		this.insert_date = insert_date;
	}
	
}
