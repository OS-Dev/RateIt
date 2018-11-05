package csc472.depaul.edu.rateit;

public class Product {
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

    Product(String productName, String imgSrc, String productDescription,
                int timesRated, int totalRating){
        this.productName = productName;
        this.imgSrc = imgSrc;
        this.productDescription = productDescription;
        this.timesRated = timesRated;
        this.totalRating = totalRating;
        this.avgRating = totalRating/timesRated;
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
}
