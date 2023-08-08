package com.example.ipdda.profile.coupon;

public class CouponVO {
    private int coupon_no,member_no,admin_no,coupon_img,discount_amount;
    private String coupon_title,coupon_context,deadline_date,coupon_status;

    public CouponVO(int coupon_no, int member_no, int admin_no, int coupon_img, int discount_amount, String coupon_title, String coupon_context, String deadline_date, String coupon_status) {
        this.coupon_no = coupon_no;
        this.member_no = member_no;
        this.admin_no = admin_no;
        this.coupon_img = coupon_img;
        this.discount_amount = discount_amount;
        this.coupon_title = coupon_title;
        this.coupon_context = coupon_context;
        this.deadline_date = deadline_date;
        this.coupon_status = coupon_status;
    }

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

    public int getCoupon_img() {
        return coupon_img;
    }

    public void setCoupon_img(int coupon_img) {
        this.coupon_img = coupon_img;
    }

    public int getDiscount_amount() {
        return discount_amount;
    }

    public void setDiscount_amount(int discount_amount) {
        this.discount_amount = discount_amount;
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

    public String getDeadline_date() {
        return deadline_date;
    }

    public void setDeadline_date(String deadline_date) {
        this.deadline_date = deadline_date;
    }

    public String getCoupon_status() {
        return coupon_status;
    }

    public void setCoupon_status(String coupon_status) {
        this.coupon_status = coupon_status;
    }
}
