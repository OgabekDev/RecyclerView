package dev.ogabek.recyclerview17_networkingwithasynchttpfuelvolleyokhttpretrofit.model;

public class Player {

    private String id, name, country, city, imgURL;

    public Player(String id, String name, String country, String city, String imgURL) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.imgURL = imgURL;
    }

    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public String getCity() {
        return city;
    }
    public String getCountry() {
        return country;
    }
    public String getImageURL() {
        return imgURL;
    }

    public void setImageURL(String imageURL) {
        this.imgURL = imageURL;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setCountry(String country) {
        this.country = country;
    }

}
