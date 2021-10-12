/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mhealth;

/**
 *
 * @author PamaiKS
 */
public class Product {

    private String province;
    private int infected;
    private int death;

    public Product() {
        this.province = "";
        this.infected = 0;
        this.death = 0;
    }

    public Product(String province, int infected, int death) {
        this.province = province;
        this.infected = infected;
        this.death = death;
    }

//    public String getName() {
//        return province;
//    }
//
//    public void setName(String name) {
//        this.province = name;
//    }
//
//    public double getPrice() {
//        return infected;
//    }
//
//    public void setPrice(int price) {
//        this.infected = price;
//    }
//
//    public int getQuantity() {
//        return death;
//    }
//
//    public void setQuantity(int quantity) {
//        this.death = quantity;
//    }
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public int getInfected() {
        return infected;
    }

    public void setInfected(int infected) {
        this.infected = infected;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

}
