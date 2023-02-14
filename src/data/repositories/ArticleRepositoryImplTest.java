package data.repositories;

import data.models.Article;
import data.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleRepositoryImplTest {
    private ArticleRepository articleRepository;

    private Article article;

    @BeforeEach
    void setUp() {
        articleRepository = new ArticleRepositoryImpl();
        article = new Article();
        article.setTitle("Title");
        article.setBody("Body");
    }

    @Test
    public void saveOneArticle_countThatArticleIsOneTest() {
        Article article = new Article();
        articleRepository.save(article);
        assertEquals(1, articleRepository.countArticle());
    }

    @Test
    public void saveOneArticle_idOfArticleIsOneTest() {
        Article savedArticle = articleRepository.save(article);
        assertEquals(1, savedArticle.getId());
    }

    @DisplayName("Article to update test")
    @Test
    public void saveTwoArticle_idOfArticleIsOneTest() {
        Article savedArticle = articleRepository.save(article);
        assertEquals(1, articleRepository.countArticle());
        savedArticle.setTitle("New title");
        articleRepository.save(savedArticle);
        assertEquals(1, articleRepository.countArticle());
    }

    @Test
    public void saveOneArticle_findArticleByIdTest() {
        Article savedArticle = articleRepository.save(article);
        assertEquals(1, savedArticle.getId());
        Article foundArticle = articleRepository.findById(1);
        assertEquals(foundArticle, savedArticle);
    }


    @Test
    public void saveOneArticle_deleteOneArticle_countArticleIsZeroTest() {
        Article savedArticle = articleRepository.save(article);
        assertEquals(1, savedArticle.getId());
        articleRepository.delete(1);
        assertEquals(0, articleRepository.countArticle());
    }

}