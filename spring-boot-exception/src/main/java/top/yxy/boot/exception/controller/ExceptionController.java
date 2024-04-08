package top.yxy.boot.exception.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.yxy.boot.exception.service.MyService;

/**
 * @author Administrator
 */
@RestController
public class ExceptionController {
    @Resource
    public MyService myService;

    @GetMapping("/user/{id}")
    public void getUser(@PathVariable("id") Integer id){
    if (id == 1){
        myService.unAuthorizedError();
    }else {
        myService.serverError();
    }
    }
}
