package com.changjiang.score.score.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.changjiang.score.common.Result;
import com.changjiang.score.score.entity.ScStudent;
import com.changjiang.score.score.service.IScStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XGLins
 * @date 2023/4/6 9:05
 */
@RestController
@RequestMapping("/score/scStudent")
public class ScStudentController {

    //自动装配
    @Autowired
    private IScStudentService scStudentService;

    @GetMapping("list")
    public Result<Page<ScStudent>> list(Page<ScStudent> page, ScStudent scStudent) {
        System.out.println(page.getSize());
        System.out.println(scStudent);
        QueryWrapper<ScStudent> query = Wrappers.query(scStudent);

        Page<ScStudent> pageRes = scStudentService.page(page, query);
        System.out.println("查询结果" + pageRes.getRecords());
        return Result.ok(pageRes);
//        return Result.ok();
    }

}
