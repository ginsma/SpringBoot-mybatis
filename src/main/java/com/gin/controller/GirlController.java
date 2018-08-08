package com.gin.controller;

import com.gin.domain.Girl;
import com.gin.domain.Result;
import com.gin.repository.GirlRepository;
import com.gin.service.GirlService;
import com.gin.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Created by Jean on 2018/8/2.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return  girlRepository.findAll();

    }

    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        Result result = new Result();
        if(bindingResult.hasErrors()) {
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        Girl girl1 = new Girl();
        girl1.setCupSize(girl.getCupSize());
        girl1.setAge(girl.getAge());

        return ResultUtil.success(girlRepository.save(girl1));
    }
    //查询
    @GetMapping(value = "/girls/{id}")
    public Optional<Girl> girlFindOne(@PathVariable("id") Integer id) {

        return girlRepository.findById(id);
    }

    //更新
    @PostMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
    @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    //删除
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {

        girlRepository.deleteById(id);
    }

    //删除
    @GetMapping(value = "/girls/age/{age}")
    public void girlFindAge(@PathVariable("age") Integer age) {

        girlRepository.findByAge(age);
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }

    @GetMapping(value = "/girls/getOne/{id}")
    public Girl getOne(@PathVariable("id") Integer id) throws Exception {
        return girlService.findOne(id);
    }
}
