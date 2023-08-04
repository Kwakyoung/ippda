package coupon;

import java.sql.Date;

public class CouponVO {
	private int coupon_no, member_no, admin_no;
	private String coupon_title, coupon_context;
	private Date deadline_date;
	
	
	public int getCoupon_no() {
		return coupon_no;
	}
	public void setCoupon_no(int coupon_no) {
		this.coupon_no = coupon_no;
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
	public String getCoupon_title() {
		return coupon_title;
	}
	public void setCoupon_title(String coupon_title) {
		this.coupon_title = coupon_title;
	}
	public String getCoupon_context() {
		return coupon_context;
	}
	public void setCoupon_context(String coupon_context) {
		this.coupon_context = coupon_context;
	}
	public Date getDeadline_date() {
		return deadline_date;
	}
	public void setDeadline_date(Date deadline_date) {
		this.deadline_date = deadline_date;
	}
	
	
}
