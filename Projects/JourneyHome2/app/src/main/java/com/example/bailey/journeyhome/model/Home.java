package com.example.bailey.journeyhome.model;

/**
 * Created by kingo on 11/27/2017.
 */

public class Home {
    private String Address;
    private String BuyersEmail;
    private String RealtorsEmail;
    private int home_id;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }



    public String getBuyersEmail() {
        return BuyersEmail;
    }

    public void setBuyersEmail(String buyersEmail) {
        BuyersEmail = buyersEmail;
    }

    public String getRealtorsEmail() {
        return RealtorsEmail;
    }

    public void setRealtorsEmail(String realtorsEmail) {
        RealtorsEmail = realtorsEmail;
    }

    public int getHome_id() {
        return home_id;
    }

    public void setHome_id(int home_id) {
        this.home_id = home_id;
    }
    public String toString() {
        return "Home  [home_id=" + home_id + ", home_address=" + Address + ", home_buyersEmail=" + BuyersEmail + ",home_realtorsEmail="+RealtorsEmail +"]";     }


}
