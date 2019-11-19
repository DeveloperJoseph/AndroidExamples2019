package joseph.developer.peru.consumewebservices.Models;

import java.io.Serializable;

public class Items implements Serializable {
    private Long idItem;
    private String imageURL;
    private String creator;
    private Integer likes;

    public Items(Long idItem, String imageURL, String creator, Integer likes) {
        this.idItem = idItem;
        this.imageURL = imageURL;
        this.creator = creator;
        this.likes = likes;
    }

    public  Items(){}

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}
