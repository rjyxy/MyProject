package top.yxy.boot.task;
import org.springframework.stereotype.Component;

@Component
public class SyncTask extends AbstractTask {
    @Override
    public void doTaskOne() throws Exception {
        super.doTaskOne();
    }

    @Override
    public void doTaskTwo() throws Exception {
        super.doTaskTwo();
    }

    @Override
    public void doTaskThree() throws Exception {
        super.doTaskThree();
    }
}