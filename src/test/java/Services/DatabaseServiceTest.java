package Services;

import Exceptions.NullArticle;
import Models.ArticleModel;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

public class DatabaseServiceTest extends ApplicationTest {
    @Test(expected = NullArticle.class)
    public void testCheckNullArticle() throws NullArticle {
        ArticleModel articleModel = null;
        DatabaseService.checkArticle(articleModel);
    }

}
