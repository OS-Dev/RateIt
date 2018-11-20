package csc472.depaul.edu.rateit;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    /*
     *  Product object class for storing and retrieving product information
     *
     */
    //Create variables
    private final String productName;
    private final int imgSrc;
    private final String productDescription;
    private int timesRated;
    private int totalRating;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(productName);
        out.writeInt(imgSrc);
        out.writeString(productDescription);
        out.writeInt(timesRated);
        out.writeInt(totalRating);
    }

    public static final Parcelable.Creator<Product> CREATOR
            = new Parcelable.Creator<Product>() {
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    private Product(Parcel in) {
        productName = in.readString();
        imgSrc = in.readInt();
        productDescription = in.readString();
        timesRated = in.readInt();
        totalRating = in.readInt();
    }
    //Product Class Constructor
    public Product(String productName, int imgSrc, String productDescription,
                int timesRated, int totalRating){
        this.productName = productName;
        this.imgSrc = imgSrc;
        this.productDescription = productDescription;
        this.timesRated = timesRated;
        this.totalRating = totalRating;
    }

    public void incTimesRated(){
        timesRated++;
    }
    public int getImgSrc(){
        return imgSrc;
    }
    public String getProductName(){
        return productName;
    }
    public String getProductDescription(){
        return  productDescription;
    }
    public  int getAvgRating(){
        return this.totalRating/this.timesRated;
    }

    public void addRating(int rating){
        this.totalRating+=rating;
        this.incTimesRated();
    }
    public void updateRating(int oldRating, int rating){
        this.totalRating -= oldRating;
        this.totalRating += rating;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(this.productName);
        buffer.append(", Average rating(");
        buffer.append(this.getAvgRating());
        buffer.append(")");
        return buffer.toString();
    }
}
