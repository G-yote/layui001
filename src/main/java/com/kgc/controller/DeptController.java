package com.kgc.controller;


import com.kgc.entity.Dept;
import com.kgc.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("list")
    @ResponseBody
    public List<Dept> findAll() {
        List<Dept> list = deptService.findAll();
        return list;
    }
}
