package com.changjiang.score.score.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.changjiang.score.common.Result;
import com.changjiang.score.score.entity.ScClass;
import com.changjiang.score.score.entity.ScCourse;
import com.changjiang.score.score.service.IScCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author XGLins
 * @date 2023/4/6 0:01
 */
@RestController
@RequestMapping("/score/scCourse")
public class ScCourseController {

    //自动装配
    @Autowired
    private IScCourseService scCourseService;

    @GetMapping("list")
    public Result<Page<ScCourse>> list(Page<ScCourse> page, ScCourse scCourse) {
        System.out.println(page.getSize());
        System.out.println(scCourse);
        QueryWrapper<ScCourse> query = Wrappers.query(scCourse);

        Page<ScCourse> pageRes = scCourseService.page(page, query);
        System.out.println("查询结果" + pageRes.getRecords());
        return Result.ok(pageRes);
//        return Result.ok();
    }

    // 新增=================================================================
    @PostMapping("insert")
    public Result<Integer> insert(@RequestBody ScCourse scCourse){
        scCourseService.save(scCourse);
        return Result.ok();
    }

    @GetMapping("{id}")
    public Result<ScCourse> findById(@PathVariable Integer id){

        ScCourse bean = scCourseService.getById(id);
        return Result.ok(bean);
    }

    // 修改----------------------------------------------------------------
    @PutMapping("update")
    public Result<ScCourse> updateById(@RequestBody ScCourse scCourse){
        scCourseService.updateById(scCourse);
        return Result.ok();
    }

    // 删除----------------------------------------------------------------
    @DeleteMapping("delete/{id}")
    public Result<ScCourse> deleteById(@PathVariable Integer id){
        scCourseService.removeById(id);
        return Result.ok();
    }

}
