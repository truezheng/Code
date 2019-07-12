package com.atguigu.mybatis_plus_boot;


import com.atguigu.mybatis_plus_boot.entity.User;
import com.atguigu.mybatis_plus_boot.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CRUDTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("114");
        user.setAge(18);
        user.setEmail("11@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user.getId());
    }

    @Test
    public void testUpdateById(){

        User user = new User();
        user.setId(1L);
        user.setAge(28);

        int result = userMapper.updateById(user);
        System.out.println(result);
    }


    @Test
    public void test(){
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPage(page,null);

        List<User> users = page.getRecords();
        users.forEach(System.out::println);

        long current = page.getCurrent();
        long size = page.getSize();
        long total = page.getTotal();
        long pages = page.getPages();
        boolean hasNext = page.hasNext();
        boolean hasPrevious = page.hasPrevious();
    }

    @Test
    public void testSelectByMap(){

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Helen");
        map.put("age", 18);
        List<User> users = userMapper.selectByMap(map);

        users.forEach(System.out::println);
    }


    @Test
    public void testSelectMapsPage() {

        Page<User> page = new Page<>(1, 5);
        IPage<Map<String, Object>> mapIPage = userMapper.selectMapsPage(page, null);
        //注意：此行必须使用 mapIPage 获取记录列表，否则会有数据类型转换错误
        mapIPage.getRecords().forEach(System.out::println);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }




        /**
         * SQL执行效率插件
         */
        @Bean
        @Profile({"dev","test"})// 设置 dev test 环境开启
        public PerformanceInterceptor performanceInterceptor() {
            performanceInterceptor().setMaxTime(100);//ms,超过此处设置的ms则sql不执行
            performanceInterceptor().setFormat(true);//对sql进行格式化输出
            return new PerformanceInterceptor();
        }


}





