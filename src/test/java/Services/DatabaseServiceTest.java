package Services;

import Exceptions.NullArticle;
import Exceptions.NullArticleFields;
import Models.ArticleModel;
import Models.ArticleState;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.util.ArrayList;

public class DatabaseServiceTest extends ApplicationTest {
    private ArticleModel articleModel = new ArticleModel("a", "b", "c", ArticleState.PENDING);

    @Test(expected = NullArticle.class)
    public void testCheckNullArticle() throws NullArticle {
        ArticleModel articleModel = null;
        DatabaseService.checkArticle(articleModel);
    }

    @Test(expected = NullArticleFields.class)
    public void testCheckNullArticleAuthor() throws NullArticleFields {
        ArticleModel articleModel = new ArticleModel("", "abc", "fdsdc", ArticleState.PENDING);
        DatabaseService.checkArticleFields(articleModel);
    }

    @Test(expected = NullArticleFields.class)
    public void testCheckNullArticleName() throws NullArticleFields {
        ArticleModel articleModel = new ArticleModel("aaa", "", "fdsdc", ArticleState.PENDING);
        DatabaseService.checkArticleFields(articleModel);
    }

    @Test(expected = NullArticleFields.class)
    public void testCheckNullContentName() throws NullArticleFields {
        ArticleModel articleModel = new ArticleModel("aaa", "bbb", "", ArticleState.PENDING);
        DatabaseService.checkArticleFields(articleModel);
    }

    @Test(expected = NullArticleFields.class)
    public void testCheckNullArticleStateName() throws NullArticleFields {
        ArticleModel articleModel = new ArticleModel("aaa", "bbb", "ccc", null);
        DatabaseService.checkArticleFields(articleModel);
    }

    @Test
    public void testAddArticle() {

        ArrayList<ArticleModel> articles = DatabaseService.getAllArticles();
        articles.add(articleModel);
        DatabaseService.addArticle(articleModel);
        ArrayList<ArticleModel> articles2 = DatabaseService.getAllArticles();
        Gson gson = new Gson();
        String articlesJSON = gson.toJson(articles);
        String articles2JSON = gson.toJson(articles2);
        Assert.assertEquals(articlesJSON, articles2JSON);
    }

    @Test
    public void testEditUserArticle(){
        ArrayList<ArticleModel> articles = DatabaseService.getUserArticles("adi");
        articleModel.setAutor("adi");
        articles.add(articleModel);
        DatabaseService.addArticle(articleModel);
        articleModel.setContinut("nou");
        DatabaseService.editArticle(articleModel);

        for(int i=0;i<articles.size();i++)
            if(articleModel.getKey().equals(articles.get(i).getKey()))
            {
                articleModel.setContinut("nou");
            }

        ArrayList<ArticleModel> articles2 = DatabaseService.getUserArticles("adi");
        Gson gson = new Gson();
        String articlesJSON = gson.toJson(articles);
        String articles2JSON = gson.toJson(articles2);
        Assert.assertEquals(articlesJSON, articles2JSON);
    }

}
