/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.bean;

/**
 *
 * @author STD-PC
 */
public class appDatamin {
    private String id;
    private String App;
    private String Category;
    private String Rating;
//    private String Reviews;
//    private String Size;
//    private String Installs;
//    private String Type;
    private String Price;
    private String Content_Rating;
//    private String Genres;

    public appDatamin(String id,String App, String Category, String Rating, String Price, String Content_Rating) {
        this.id = id;
        this.App = App;
        this.Category = Category;
        this.Rating = Rating;
//        this.Reviews = Reviews;
//        this.Size = Size;
//        this.Installs = Installs;
//        this.Type = Type;
        this.Price = Price;
        this.Content_Rating = Content_Rating;
//        this.Genres = Genres;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getApp() {
        return App;
    }

    public void setApp(String App) {
        this.App = App;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String Rating) {
        this.Rating = Rating;
    }

//    public String getReviews() {
//        return Reviews;
//    }
//
//    public void setReviews(String Reviews) {
//        this.Reviews = Reviews;
//    }
//
//    public String getSize() {
//        return Size;
//    }
//
//    public void setSize(String Size) {
//        this.Size = Size;
//    }
//
//    public String getInstalls() {
//        return Installs;
//    }
//
//    public void setInstalls(String Installs) {
//        this.Installs = Installs;
//    }
//
//    public String getType() {
//        return Type;
//    }
//
//    public void setType(String Type) {
//        this.Type = Type;
//    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getContent_Rating() {
        return Content_Rating;
    }

    public void setContent_Rating(String Content_Rating) {
        this.Content_Rating = Content_Rating;
    }

//    public String getGenres() {
//        return Genres;
//    }
//
//    public void setGenres(String Genres) {
//        this.Genres = Genres;
//    }
//    
}
