package csc472.depaul.edu.rateit;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {
    /*
     *  Product object class for storing and retrieving product information
     *
     */
    private final String productName;
    private final String imgSrc;
    private final String productDescription;
    private int timesRated;
    private int totalRating;
    private int avgRating;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(productName);
        out.writeString(imgSrc);
        out.writeString(productDescription);
        out.writeInt(timesRated);
        out.writeInt(totalRating);
        //Don't think avgRating is needed here
        out.writeInt(avgRating);
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
        imgSrc = in.readString();
        productDescription = in.readString();
        timesRated = in.readInt();
        totalRating = in.readInt();
        //Don't think avgRating is needed here
        avgRating = in.readInt();
    }

    public Product(String productName, String imgSrc, String productDescription,
                int timesRated, int totalRating){
        this.productName = productName;
        this.imgSrc = imgSrc;
        this.productDescription = productDescription;
        this.timesRated = timesRated;
        this.totalRating = totalRating;
        this.avgRating = this.totalRating/this.timesRated;
    }

    public void incTimesRated(){
        timesRated++;
    }
    public String getImgSrc(){
        return imgSrc;
    }
    public String getProductName(){
        return productName;
    }
    public String getProductDescription(){
        return  productDescription;
    }
    public  int getAvgRating(){
        return avgRating;
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
    public int hashCode() {
        int hCode = 17;
        hCode = 37 * hCode + productName.hashCode();
        hCode = 37 * hCode + imgSrc.hashCode();
        hCode = 37 * hCode + productDescription.hashCode();
        return hCode;
    }
    public int compareTo(Product that){
        if (this.getProductName() != that.getProductName()){
            return this.productName.hashCode() - that.productName.hashCode();
        }
        else if (this.getProductName() == that.getProductName()){
            return  this.imgSrc.compareTo(that.imgSrc);
        }
        else{
            return  this.productDescription.compareTo(that.productDescription);
        }
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

    public Integer getTimesRated() {
        return timesRated;
    }

    public Integer getTotalRating() {
        return totalRating;
    }
}
