package top.yxy.boot.task;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AsyncExecutorTaskTest {

    @Resource
    private AsyncExecutorTask task;

    @Test
    public void testAsyncExecutorTask() throws Exception {
        task.doTaskOneCallback();
        task.doTaskTwoCallback();
        task.doTaskThreeCallback();
        sleep(30 * 1000L);
    }
}