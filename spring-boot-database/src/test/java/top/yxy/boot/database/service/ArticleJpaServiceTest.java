package top.yxy.boot.database.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.yxy.boot.database.entity.Article;

import java.util.List;

@SpringBootTest
@Slf4j
class ArticleJpaServiceTest {

    @Resource
    private ArticleJpaService articleJpaService;

    @Test
    void saveArticle() {
        Article article = Article.builder()
                .author("yxy")
                .title("Spring Boot JPA")
                .content("Spring Boot JPA")
                .build();
        articleJpaService.saveArticle(article);
    }

    @Test
    void updateArticle() {
        Article article = Article.builder()
                .id(1)
                .author("yxy")
                .title("Spring Boot JPA 2")
                .content("Spring Boot JPA 2")
                .build();
        articleJpaService.updateArticle(article);
    }

    @Test
    void getArticleById() {
        Article article = articleJpaService.getArticleById(1);
        log.info(article.toString());
    }


    @Test
    void findAll() {
        List<Article> list = articleJpaService.findAll();
        list.forEach(System.out::println);
    }

    @Test
    void deleteArticleById() {
        articleJpaService.deleteArticleById(1);
    }
}