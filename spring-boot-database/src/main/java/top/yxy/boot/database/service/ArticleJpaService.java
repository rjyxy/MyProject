package top.yxy.boot.database.service;

import top.yxy.boot.database.entity.Article;

import java.util.List;

/**
 * @author Administrator
 */

public interface ArticleJpaService {
    void saveArticle(Article article);

    void updateArticle(Article article);

    Article getArticleById(int id);

    List<Article> findAll();

    void deleteArticleById(int id);
}
