package Services;

import Exceptions.NullArticle;
import Exceptions.NullArticleFields;
import Models.ArticleModel;
import Models.ArticleState;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class DatabaseServiceTest extends ApplicationTest {
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

}
