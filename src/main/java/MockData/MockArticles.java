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

    public static ArrayList<ArticleModel> acceptedArticles
            = new ArrayList<ArticleModel>() {
        {
            add(new ArticleModel("autor10", "nume10", "continwefadcontinwecontinwefadcontinwefadfvdffdfddffdfdfdfddffddut1continwefad1fadfvdffdfddffdfdfdfddffddut1continwefad1", ArticleState.ACCEPTED));
            add(new ArticleModel("autor11", "nume11", "continut11", ArticleState.ACCEPTED));
            add(new ArticleModel("autor12", "nume12", "continut12", ArticleState.ACCEPTED));
            add(new ArticleModel("autor13", "nume13", "continut13", ArticleState.ACCEPTED));
            add(new ArticleModel("autor14", "nume14", "continut14", ArticleState.ACCEPTED));
            add(new ArticleModel("autor15", "nume15", "continut15", ArticleState.ACCEPTED));
            add(new ArticleModel("autor16", "nume16", "continut16", ArticleState.ACCEPTED));
            add(new ArticleModel("autor16", "nume16", "continut16", ArticleState.ACCEPTED));
            add(new ArticleModel("autor16", "nume16", "continut16", ArticleState.ACCEPTED));

        }
    };
}
