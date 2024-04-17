//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package top.yxy.boot.config.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FamilyTest {
    @Resource
    private Family family;

    public FamilyTest() {
    }

    @Test
    void testFamily() {
        System.out.println(this.family);
    }
}
