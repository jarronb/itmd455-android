package com.example.jot.journeyhome;

/**
 * Created by Jot on 11/27/2017.
 */

public class Home {

        private int homeId;
        private String address;
        private String buyersEmail;
        private String realtorsEmail;


        public int getHomeId() {
            return homeId;
        }

        public void setHomeId(int homeId) {
            this.homeId = homeId;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getBuyersEmail() {
            return buyersEmail;
        }

        public void setBuyersEmail(String buyersEmail) {
            this.buyersEmail = buyersEmail;
        }

        public String getRealtorsEmail() {
            return realtorsEmail;
        }

        public void setRealtorsEmail(String realtorsEmail) {
            this.realtorsEmail = realtorsEmail;
        }

        @Override
        public String toString() {
            return "Home [homeId=" + homeId + ", address=" + address + ", buyersEmail=" + buyersEmail + ", realtorsEmail=" + realtorsEmail + "]";
        }
    }
