package joseph.developer.peru.gridviewexamples.models;

import java.io.Serializable;

public class Product implements Serializable {


    private String idProduct;
    private String nameProduct;
    private Double priceProduct;
    private Integer photoProduct;

    public Product(){}

    public Product(String idProduct, String nameProduct, Double priceProduct, Integer photoProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.photoProduct = photoProduct;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public Integer getPhotoProduct() {
        return photoProduct;
    }

    public void setPhotoProduct(Integer photoProduct) {
        this.photoProduct = photoProduct;
    }
}
