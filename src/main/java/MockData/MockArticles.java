package MockData;

import Models.ArticleModel;
import Models.ArticleState;

import java.util.ArrayList;
import java.util.List;

public class MockArticles {
    public static ArrayList<ArticleModel> pendingArticles
            = new ArrayList<ArticleModel>() {
        {
            add(new ArticleModel("autor1", "nume1", "continwefadcontinwefadfvdffdfddffdfdfdfddffddut1continwefad1", ArticleState.PENDING));
            add(new ArticleModel("autor2", "nume2", "continut2", ArticleState.PENDING));
            add(new ArticleModel("autor3", "nume3", "continut3", ArticleState.PENDING));
            add(new ArticleModel("autor4", "nume4", "continut4", ArticleState.PENDING));
            add(new ArticleModel("autor5", "nume4", "continut4", ArticleState.PENDING));
            add(new ArticleModel("autor6", "nume4", "continut4", ArticleState.PENDING));
            add(new ArticleModel("autor7", "nume4", "continut4", ArticleState.PENDING));

        }
    };
}
