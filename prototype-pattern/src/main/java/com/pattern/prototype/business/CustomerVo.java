package com.pattern.prototype.business;

import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wq on 2019/3/18
 */
public class CustomerVo implements Cloneable, Serializable {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 性别
     */
    private String gender;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 地址
     */
    private String address;
    /**
     * 联系方式
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 业余爱好
     */
    private List<String> hobbies;

    /**
     * 会员等级
     */
    private Integer level;
    /**
     * 会员积分
     */
    private long score;
    /**
     * 会员卡号
     */
    private String memberCard;
    /**
     * 账户余额
     */
    private double money;
    /**
     * 账户状态
     */
    private byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public String getMemberCard() {
        return memberCard;
    }

    public void setMemberCard(String memberCard) {
        this.memberCard = memberCard;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        CustomerPo customer = new CustomerPo();
        BeanUtils.copyProperties(customer, this);
        return customer;
    }
}
