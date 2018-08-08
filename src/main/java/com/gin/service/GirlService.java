package com.gin.service;

import com.gin.domain.Girl;
import com.gin.enums.ResultEnum;
import com.gin.exception.GirlException;
import com.gin.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

/**
 * Created by Jean on 2018/8/2.
 */
@Service
public class GirlService {


    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    @PostMapping(value = "/girls")
    public void girlAddTwo() {
        Girl girl1 = new Girl();
        girl1.setCupSize("A");
        girl1.setAge(15);

        girlRepository.save(girl1);

        Girl girl2 = new Girl();
        girl2.setCupSize("C");
        girl2.setAge(19);

        girlRepository.save(girl2);
    }

    public Integer getAge(Integer id) throws Exception {
        //Optional<Girl> girl = girlRepository.findById(id);
        //Integer age = girl.get().getAge();
        int age = 8;
        if (age < 10) {
            //返回 你还在上小学
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age >10 && age < 16) {
            //返回 你可能在上初中
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }


        return 0;

    }

    /**
     * 通过id找一个女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id) {
        return girlRepository.findById(id).get();
    }


}
