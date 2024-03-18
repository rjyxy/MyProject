package top.yxy.boot.database.dao;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.yxy.boot.database.entity.Article;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ArticleJDBCDAOTest {
    @Resource
    private ArticleJDBCDAO articleJDBCDAO;

    @Test
    void save(){
        Article article = Article.builder()
                .author("gaoshan")
                .title("software")
                .content("software")
                .build();
        int n = articleJDBCDAO.save(article);
        log.info(String.valueOf(n));
    }

    @Test
    void updateById() {
        Article article = new Article();
        article.setAuthor("sherry");
        article.setTitle("vue");
        article.setContent("vue");
        article.setId(3);
        articleJDBCDAO.updateById(article);
    }

    @Test
    void findById() {
        articleJDBCDAO.findById(3L);
    }


    @Test
    void findAll() {
        articleJDBCDAO.findAll();
    }

    @Test
    void deleteById() {
        articleJDBCDAO.deleteById(6L);
    }

}