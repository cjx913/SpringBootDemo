package com.cjx913.springbootdemo.test;

import com.cjx913.springbootdemo.entity.Actor;
import com.cjx913.springbootdemo.entity.Movie;
import com.cjx913.springbootdemo.entity.Role;
import com.cjx913.springbootdemo.repositories.ActorRepository;
import com.cjx913.springbootdemo.repositories.MovieRepository;
import com.cjx913.springbootdemo.repositories.RoleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfiguration.class})
public class RepositoryTest {
    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Before
    public  void initData() throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        movieRepository.deleteAll();
        roleRepository.deleteAll();
        actorRepository.deleteAll();

        Movie movie = new Movie();
        movie.setName("紫罗兰永恒花园");
        movie.setPhoto("/images/ziluolanyonghenghuayuan.jpg");
        movie.setShowDate(sdf.parse("2018-01-10"));

        Actor scyy = new Actor();
        scyy.setName("石川由依");
        scyy.setSex(1);
        scyy.setBorn(sdf.parse("1989-5-30"));

        Actor zawr = new Actor("子安武人",0,sdf.parse("1967-5-5"));
//        scyy.setName("子安武人");

        Actor lcdf = new Actor("浪川大辅",0,sdf.parse("1976-3-29"));
//        scyy.setName("浪川大辅");

        Actor ytl = new Actor("远藤绫",1,sdf.parse("1980-2-17"));
//        scyy.setName("远藤绫");

        movie.addRole("薇尔莉特·伊芙加登",scyy);
        movie.addRole("克劳迪亚·霍金斯",zawr);
        movie.addRole("基尔伯特·布甘比利亚",lcdf);
        movie.addRole("嘉德丽雅·波德莱尔",ytl);

        actorRepository.save(scyy);
        actorRepository.save(zawr);
        actorRepository.save(lcdf);
        actorRepository.save(ytl);

        movieRepository.save(movie);

        Assert.notNull(movie.getId());

    }

    @Test
    public void test(){
        Movie movie = movieRepository.findByName("紫罗兰永恒花园");
        Assert.notNull(movie);

        for(Role role: movie.getRoles()){
            System.out.println("actor:"+role.getActor().getName()+",role:"+role.getName());
        }
    }

}
