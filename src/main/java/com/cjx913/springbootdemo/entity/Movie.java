package com.cjx913.springbootdemo.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//表示实体类与数据库有映射关系
@Entity
//设置数据库的表名
@Table(name = "movie")
public class Movie {
    //属性对应的是数据库表的主键列
    @Id
    //主键生成策略
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String photo;
    //配置对应的字段名
    @Column(name = "show_data")//两个单词连接命名
    //设置日期格式
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date showDate;

    //一对多关联关系配置
    /**
     * cascade，级联操作
     * targetEntity，多的一方对应的实体类
     * mappedBy，多的一方实体类中，与一关联的属性
     * fetch，懒加载
     */
    @OneToMany(cascade = CascadeType.ALL,targetEntity = Role.class,mappedBy = "movie",fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList <Role>();

    public Movie() {
    }

    public Movie(String name, String photo, Date showDate) {
        this.name = name;
        this.photo = photo;
        this.showDate = showDate;
    }

    public Movie(String name, String photo, Date showDate, List <Role> roles) {
        this.name = name;
        this.photo = photo;
        this.showDate = showDate;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public List <Role> getRoles() {
        return roles;
    }

    public void setRoles(List <Role> roles) {
        this.roles = roles;
    }

    public void addRole(String name, Actor actor){
        Role role = new Role(name,this,actor);
        this.roles.add(role);
    }
}
