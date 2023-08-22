package inventory;

public class InventoryVO {
	private int
		inventory_no, goods_no, store_no,  goods_cnt;
	private String 
		goods_size, goods_color;
	public int getInventory_no() {
		return inventory_no;
	}
	public void setInventory_no(int inventory_no) {
		this.inventory_no = inventory_no;
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
	public int getGoods_cnt() {
		return goods_cnt;
	}
	public void setGoods_cnt(int goods_cnt) {
		this.goods_cnt = goods_cnt;
	}
	public String getGoods_size() {
		return goods_size;
	}
	public void setGoods_size(String goods_size) {
		this.goods_size = goods_size;
	}
	public String getGoods_color() {
		return goods_color;
	}
	public void setGoods_color(String goods_color) {
		this.goods_color = goods_color;
	}
	
		
}
