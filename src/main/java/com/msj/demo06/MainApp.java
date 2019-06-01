package com.msj.demo06;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


//jdbcTemplate 进行增删改查
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean06.xml")

public class MainApp {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void insert(){
        String sql = "insert into user values(?,?,?)";
        int num = jdbcTemplate.update(sql,4,"小黄",18);
        System.out.println(num);
    }

    @Test
    public void delete(){
        String sql = "delete from user where id = ?";
        int num = jdbcTemplate.update(sql,"4");
        System.out.println(num);
    }
    @Test
    public void update(){
        String sql = "update user set age = ? where id = ?";
        int num = jdbcTemplate.update(sql,11,1);
        System.out.println(num);
    }
    //查询总条数
    @Test
    public void selectCount(){
        String sql = "select count(*) from user";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println("总条数："+count);
    }
//    查询
// RowMapper 不支持 queryForList()方法，需要手动映射它。
    @Test
    public void select(){
        String sql = "select * from user";
        List<User> userList = new ArrayList<User>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for(Map row:rows){
            User user = new User();
            user.setId((Integer)row.get("id"));
            user.setName((String)row.get("name"));
            user.setAge((Integer)row.get("age"));
            userList.add(user);
        }
        System.out.println(userList);
    }
    //查询：使用BeanPropertyRowMapper
    @Test
    public void select2(){
        String sql = "select * from user";
        List<User> userList = jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class));
        System.out.println(userList);
    }

    @Test
    public void select3(){
        String sql = "select * from user";
        List<Map<String,Object>> maps = jdbcTemplate.queryForList(sql);
        System.out.println(maps);
    }
//查询单条语句
    @Test
    public void selectOne(){
        String sql = "select * from user where id = ?";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
        User user = jdbcTemplate.queryForObject(sql, rowMapper, 2);
        System.out.println(user);
    }

    @Test
    public void selectOne2(){
        String sql = "select * from user where id = ?";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, 2);
        System.out.println(map);
    }

    @Test
    public void selectOne3(){
        String sql = "select * from user where name = ?";
        final User userOne = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            public User mapRow(ResultSet rs, int i) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setAge(rs.getInt("age"));
                return null;
            }
        },"小花");
        System.out.println(userOne);
    }
}
