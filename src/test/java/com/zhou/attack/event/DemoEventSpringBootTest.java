package com.zhou.attack.event;

import com.zhou.attack.AttackApplication;
import com.zhou.attack.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhoumb on 2018/12/20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AttackApplication.class)
public class DemoEventSpringBootTest {

    @Autowired
    DemoService demoService;

    @Test
    public void testHandle(){
        demoService.handle("小明查看你的名片");
        demoService.handle("小红查看你的名片");
        demoService.handle2("需要计算小刚的亲密度");
        demoService.handle2("需要计算小爱的亲密度");
    }
}
