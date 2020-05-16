package Services;

import Models.ArticleModel;
import Models.UserModel;
import View.AlertBox;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;

public class DatabaseService {
    private static String articlesFile="articles.json";

    public static void addArticle(ArticleModel article){


        try  {
            ArrayList<ArticleModel>
                    allArticles= getAllArticles();

            FileWriter file = new FileWriter(articlesFile);

            if(allArticles==null) {

                allArticles=new ArrayList<ArticleModel>();
            }
            allArticles.add(article);
            String articleJson=new Gson().toJson(allArticles);
            file.write(articleJson);
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ArticleModel> getAllArticles(){
        Gson gson = new Gson();

        try{
            FileReader reader = new FileReader(articlesFile);
            ArrayList<ArticleModel> allArticles = gson.fromJson(reader,new TypeToken<ArrayList<ArticleModel>>() {}.getType());
            return allArticles;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    public static ArrayList<ArticleModel> getUserArticles(String userName){
        Gson gson = new Gson();
        ArrayList<ArticleModel> userArticles= new ArrayList<>();
        try{
            FileReader reader = new FileReader(articlesFile);
            ArrayList<ArticleModel> allArticles = gson.fromJson(reader,new TypeToken<ArrayList<ArticleModel>>() {}.getType());
            for(int i=0;i<allArticles.size();i++)
            {
                if(allArticles.get(i).getAutor().equals(userName))
                {
                    userArticles.add(allArticles.get(i));
                }
            }
            return userArticles;
        }
        catch (Exception e)
        {
            return null;
        }
    }
    public static void editArticle(ArticleModel newArticle){}

}