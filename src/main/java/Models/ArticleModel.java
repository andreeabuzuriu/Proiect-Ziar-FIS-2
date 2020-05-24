package Models;

import java.util.UUID;

public class ArticleModel {

    private String autor,nume,continut,key,feedback;
    private ArticleState articleState;

    public ArticleModel(String autor, String nume, String continut, ArticleState articleState) {
        this.autor = autor;
        this.nume = nume;
        this.continut = continut;
        this.key = UUID.randomUUID().toString();
        this.feedback="";
        this.articleState = articleState;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getContinut() {
        return continut;
    }

    public void setContinut(String continut) {
        this.continut = continut;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ArticleState getArticleState() {
        return articleState;
    }

    public void setArticleState(ArticleState articleState) {
        this.articleState = articleState;
    }
}
