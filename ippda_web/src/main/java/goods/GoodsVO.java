package goods;

import java.util.List;

import com.google.cloud.Date;



//public class GoodsVO extends GoodsOptionVO{
public class GoodsVO {
	private int  rownum ,goods_no ,store_no, goods_price, goods_sale_price, goods_sale_percent, store_delivery_tip
	, goods_middle_category,goods_sub_category, goods_style;
	
	private String goods_name, goods_info, goods_gender, goods_main_image, store_name ,goods_sub_image, goods_status;
	private Date goods_date;
	private List<OptionVO> optionList;
	public int getRownum() {
		return rownum;
	}
	public void setRownum(int rownum) {
		this.rownum = rownum;
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
	public int getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(int goods_price) {
		this.goods_price = goods_price;
	}
	public int getGoods_sale_price() {
		return goods_sale_price;
	}
	public void setGoods_sale_price(int goods_sale_price) {
		this.goods_sale_price = goods_sale_price;
	}
	public int getGoods_sale_percent() {
		return goods_sale_percent;
	}
	public void setGoods_sale_percent(int goods_sale_percent) {
		this.goods_sale_percent = goods_sale_percent;
	}
	public int getStore_delivery_tip() {
		return store_delivery_tip;
	}
	public void setStore_delivery_tip(int store_delivery_tip) {
		this.store_delivery_tip = store_delivery_tip;
	}
	public int getGoods_middle_category() {
		return goods_middle_category;
	}
	public void setGoods_middle_category(int goods_middle_category) {
		this.goods_middle_category = goods_middle_category;
	}
	public int getGoods_sub_category() {
		return goods_sub_category;
	}
	public void setGoods_sub_category(int goods_sub_category) {
		this.goods_sub_category = goods_sub_category;
	}
	public int getGoods_style() {
		return goods_style;
	}
	public void setGoods_style(int goods_style) {
		this.goods_style = goods_style;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public String getGoods_info() {
		return goods_info;
	}
	public void setGoods_info(String goods_info) {
		this.goods_info = goods_info;
	}
	public String getGoods_gender() {
		return goods_gender;
	}
	public void setGoods_gender(String goods_gender) {
		this.goods_gender = goods_gender;
	}
	public String getGoods_main_image() {
		return goods_main_image;
	}
	public void setGoods_main_image(String goods_main_image) {
		this.goods_main_image = goods_main_image;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getGoods_sub_image() {
		return goods_sub_image;
	}
	public void setGoods_sub_image(String goods_sub_image) {
		this.goods_sub_image = goods_sub_image;
	}
	public String getGoods_status() {
		return goods_status;
	}
	public void setGoods_status(String goods_status) {
		this.goods_status = goods_status;
	}
	public Date getGoods_date() {
		return goods_date;
	}
	public void setGoods_date(Date goods_date) {
		this.goods_date = goods_date;
	}
	
	public List<OptionVO> getOptionList() {
		return optionList;
	}
	public void setOptionList(List<OptionVO> optionList) {
		this.optionList = optionList;
	}
	
	
	
	
	
	

}
