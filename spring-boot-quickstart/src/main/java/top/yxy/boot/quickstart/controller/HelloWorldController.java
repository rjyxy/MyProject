package top.yxy.boot.quickstart.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String getHell0(){
        return "hello world!";
    }
}
