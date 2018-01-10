package com.cjx913.springbootdemo.controller;

import com.cjx913.springbootdemo.entity.Movie;
import com.cjx913.springbootdemo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

//控制器注解
@Controller
//配置父路径
@RequestMapping("/movie")
public class MovieController {
    //自动注入
    @Autowired
    private MovieRepository movieRepository;

    //配置路径
    @RequestMapping("/list")
    public ModelAndView list(Model model,String name){
        List <Movie> movieList = null;
        if(name==null||name.equals("")) {
            movieList = movieRepository.findAll();
        }else {
            movieList = movieRepository.findByNameLike("%"+name+"%");
        }
        model.addAttribute("movieList",movieList);
        //返回视图路径
        return new ModelAndView("movie/list");
    }

    @RequestMapping("/create")
    public ModelAndView create(Model model){
        return new ModelAndView("movie/create");
    }

    @RequestMapping("/save")
    public ModelAndView save(Model model, @Valid Movie movie, BindingResult result){
        movieRepository.save(movie);
        List<Movie> movieList = movieRepository.findAll();
        model.addAttribute("movieList",movieList);
        return new ModelAndView("movie/list");
    }

    @RequestMapping("/show")
    public ModelAndView show(Model model,Long id){
        Movie movie = movieRepository.findOne(id);
        model.addAttribute("movie",movie);
        return new ModelAndView("movie/show");
    }

    @RequestMapping("/modify")
    public ModelAndView modify(Model model,Long id){
        Movie movie = movieRepository.getOne(id);
        model.addAttribute("movie",movie);
        return new ModelAndView("movie/modify");
    }

    @RequestMapping("/editSubmit")
    public ModelAndView editSubmit(Model model,@Valid Movie movie,BindingResult result){
        movieRepository.save(movie);
        List<Movie> movieList = movieRepository.findAll();
        model.addAttribute("movieList",movieList);
        return new ModelAndView("/movie/list");
    }

    @RequestMapping("/delete")
    public ModelAndView delete(Model model,Long id){
        movieRepository.delete(id);
        List<Movie> movieList = movieRepository.findAll();
        model.addAttribute("movieList",movieList);
        return new ModelAndView("/movie/list");
    }
}
