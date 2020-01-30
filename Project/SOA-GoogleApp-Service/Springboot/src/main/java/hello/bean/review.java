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
public class review {
    final String app;
    final String review;
    final String sentiment;
    final String sentiment_Polarity;
    final String sentiment_Subjectivity;

    public review(String app, String review, String sentiment, String sentiment_Polarity, String sentiment_Subjectivity) {
        this.app = app;
        this.review = review;
        this.sentiment = sentiment;
        this.sentiment_Polarity = sentiment_Polarity;
        this.sentiment_Subjectivity = sentiment_Subjectivity;
    }

    public String getApp() {
        return app;
    }

    public String getReview() {
        return review;
    }

    public String getSentiment() {
        return sentiment;
    }

    public String getSentiment_Polarity() {
        return sentiment_Polarity;
    }

    public String getSentiment_Subjectivity() {
        return sentiment_Subjectivity;
    }
    
    
}
