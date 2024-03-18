package top.yxy.boot.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.yxy.boot.database.entity.Article;

/**
 * @author Administrator
 */
public interface ArticleJpaDAO extends JpaRepository<Article,Integer> {

    

}
