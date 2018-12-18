package id.co.heksainsurance.berasuransi;

public class Product {
    private int imageId;
    private String title;
    private String description;
    private String Photo1;

    public Product(int imageId, String title, String description, String photo) {
        this.imageId = imageId;
        this.title = title;
        this.description = description;
        this.Photo1 = photo;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto1() {
        return Photo1;
    }

    public void setPhoto1(String sPhoto1) {
        this.Photo1= sPhoto1;
    }
}
