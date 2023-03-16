package com.changjiang.score.score.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.changjiang.score.common.Result;
import com.changjiang.score.score.entity.ScTeacher;
import com.changjiang.score.score.service.IScTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/score/scTeacher")
public class ScTeacherController {

    //自动装配
    @Autowired
    private IScTeacherService scTeacherService;

    @GetMapping("list")
    public Result<Page<ScTeacher>> list(Page<ScTeacher> page,ScTeacher scTeacher) {
//        System.out.println(page.getSize());
//        System.out.println(scTeacher);
        QueryWrapper<ScTeacher> query = Wrappers.query(scTeacher);

        Page<ScTeacher> pageRes = scTeacherService.page(page, query);
        System.out.println("查询结果" + pageRes.getRecords());
        return Result.ok(pageRes);
    }

}
