package com.lihai.biyesheji.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor    //无参构造
@AllArgsConstructor  //有参构造
//和表建立映射关系
public class Manager {
    private Integer managerId;

    private String zhangHao;
    private String password;
    private String managerName;
    private String idCard;
    private String sex;
    private Integer age;


    private String managerPhone;


    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getZhangHao() {
        return zhangHao;
    }

    public void setZhangHao(String zhangHao) {
        this.zhangHao = zhangHao;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }
}
