package com.senchuuhi.iweb.modules.grapdata.controller;


import com.senchuuhi.iweb.iextend.spider.task.RentHouseTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieStartGrapController {

    @Autowired
    private RentHouseTask hmt;

    @RequestMapping("/grap")
    public void grapMovies() {
        hmt.start();
    }

}
