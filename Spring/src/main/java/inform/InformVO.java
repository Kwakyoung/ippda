package inform;

import java.sql.Date;

public class InformVO {
	private int inform_no, admin_no, inform_views;
	private String infor_title, inform_context;
	private Date insert_date;
	public int getInform_no() {
		return inform_no;
	}
	public void setInform_no(int inform_no) {
		this.inform_no = inform_no;
	}
	public int getAdmin_no() {
		return admin_no;
	}
	public void setAdmin_no(int admin_no) {
		this.admin_no = admin_no;
	}
	public int getInform_views() {
		return inform_views;
	}
	public void setInform_views(int inform_views) {
		this.inform_views = inform_views;
	}
	public String getInfor_title() {
		return infor_title;
	}
	public void setInfor_title(String infor_title) {
		this.infor_title = infor_title;
	}
	public String getInform_context() {
		return inform_context;
	}
	public void setInform_context(String inform_context) {
		this.inform_context = inform_context;
	}
	public Date getInsert_date() {
		return insert_date;
	}
	public void setInsert_date(Date insert_date) {
		this.insert_date = insert_date;
	}
	
	
}
