package data.repositories;

import data.models.Article;
import data.models.User;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepositoryImpl implements ArticleRepository {
    private int countArticle;
    private List<Article> articles = new ArrayList<>();

    @Override
    public Article save(Article article) {
        boolean articleHasNOtBeenSaved = article.getId() == 0;
        if (articleHasNOtBeenSaved) {
            article.setId(generateArticleId());
            articles.add(article);
            countArticle++;

        }
        return article;
    }


    private int generateArticleId() {
        return countArticle + 1;
    }

    @Override
    public Article findById(int id) {
        for (Article article : articles) if (article.getId() == id) return article;
        return null;
    }

    @Override
    public long countArticle() {
        return countArticle;
    }

    @Override
    public List<Article> findAll() {
        return null;
    }

    @Override
    public void delete(Article title) {
        for (Article article : articles) {
            if (article.getTitle().equalsIgnoreCase(String.valueOf(title))) {
                articles.remove(article);
                countArticle--;
                break;
            }
        }
    }
    @Override
    public void delete(int id) {
        for (Article article : articles) {
            if (article.getId() == id) {
                articles.remove(article);
                countArticle--;
                break;
            }
        }
    }
    @Override
    public void deleteAll() {
            articles.removeAll(articles);
            countArticle = articles.size();
        }
}
