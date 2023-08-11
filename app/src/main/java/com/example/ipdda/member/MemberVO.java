package com.example.ipdda.member;

public class MemberVO {
    private String member_id,
            member_pw,
            member_gender,
            member_email,
            member_nickname,
            member_phone,
            member_address,
            member_bank,
            member_bank_no,
            member_profile_image,
            member_birthday;

    public String getMember_birthday() {
        return member_birthday;
    }

    public void setMember_birthday(String member_birthday) {
        this.member_birthday = member_birthday;
    }

    private int member_no;

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

    public int getMember_no() {
        return member_no;
    }

    public void setMember_no(int member_no) {
        this.member_no = member_no;
    }
}
