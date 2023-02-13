package com.example.attempt2.model;

public class RecentData {

    String hotelName;
    String countryName;
    String price;
    Integer imageUrl;

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public RecentData (String hotelName, String countryName, String price, Integer imageUrl){
        this.hotelName= hotelName;
        this.countryName=countryName;
        this.price=price;
        this.imageUrl=imageUrl ;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

