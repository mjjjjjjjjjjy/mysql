package com.mjy.mysql.start;
/**
* @author MoJianyue
* @version 创建时间：2018年9月13日 下午7:33:15
*/
public class VO {
    private Long id;
    private String name;
    private String cardNumber;
    private String city;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public String toString() {
        return "VO [id=" + id + ", name=" + name + ", cardNumber=" + cardNumber + ", city=" + city + "]";
    }
    
}
