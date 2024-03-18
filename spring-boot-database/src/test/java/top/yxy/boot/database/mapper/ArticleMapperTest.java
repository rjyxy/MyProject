package top.yxy.boot.database.mapper;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.yxy.boot.database.entity.Article;

@SpringBootTest
class ArticleMapperTest {

    @Resource
    private  ArticleMapper articleMapper;

    @Test
    void insertArticle() {
        Article article = Article.builder()
                .author("111")
                .title("222")
                .content("222")
                .build();
        articleMapper.insertArticle(article);
    }

}