package top.yxy.boot.database.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.yxy.boot.database.dao.ArticleJpaDAO;
import top.yxy.boot.database.entity.Article;
import top.yxy.boot.database.service.ArticleJpaService;


import java.util.List;
import java.util.Optional;

/**
 * @author Administrator
 */
@Service
public class ArticleJpaServiceImpl implements ArticleJpaService {
    @Resource
    ArticleJpaDAO articleJpaDAO;

    @Override
    public void saveArticle(Article article) {
        articleJpaDAO.save(article);
    }

    @Override
    public void updateArticle(Article article) {
        articleJpaDAO.save(article);
    }

    @Override
    public Article getArticleById(int id) {
        Optional<Article> articleOptional = articleJpaDAO.findById(id);
        // JDK8 lambda 判空
        return articleOptional.orElse(null);
    }


    @Override
    public List<Article> findAll() {
        return articleJpaDAO.findAll();
    }

    @Override
    public void deleteArticleById(int id) {
        articleJpaDAO.deleteById(id);
    }
}
