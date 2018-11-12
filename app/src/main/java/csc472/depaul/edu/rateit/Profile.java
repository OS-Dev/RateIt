package csc472.depaul.edu.rateit;

import java.util.ArrayList;

public class Profile {

    private ArrayList<Product> favorites;
    private ArrayList<Product> rated;
    private String imgSrc;
    private String username;

    Profile(String name, String image) {
        this.favorites = new ArrayList<>();
        this.rated = new ArrayList<>();
        this.imgSrc = image;
        this.username = name;
        this.imgSrc = null;
    }

    public void updateProfileImg(String src) {
        imgSrc = src;
        //TODO implementation
    }

    public void changeUsername(String name) {
        username = name;
    }

    public void addFavorite(Product product) {
        favorites.add(product);
    }

    public void removeFavorite(Product product) {
        favorites.remove(product);
    }

    public void rate(Product product, int rating) {
        if (rated.contains(product)) {
            //method to update rating as implemented in Product class
            //TODO: Update method name as seen in Product
            product.updateRating(oldRating, rating);
        } else {
            //method to add rating as implemented in Product class
            //TODO: Update method name as seen in Product
            product.addRating(rating);
            rated.add(product);
        }
    }


}
