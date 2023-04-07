package com.changjiang.score.score.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.changjiang.score.common.Result;
import com.changjiang.score.score.entity.ScScore;
import com.changjiang.score.score.service.IScScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author XGLins
 * @date 2023/4/7 14:56
 */
@RestController
@RequestMapping("/score/scScore")
public class ScScoreController {

    //自动装配
    @Autowired
    private IScScoreService scScoreService;

    @GetMapping("list")
    public Result<Page<ScScore>> list(Page<ScScore> page, ScScore scScore) {
        System.out.println(page.getSize());
        System.out.println(scScore);
        QueryWrapper<ScScore> query = Wrappers.query(scScore);

        Page<ScScore> pageRes = scScoreService.page(page, query);
        System.out.println("查询结果" + pageRes.getRecords());
        return Result.ok(pageRes);
//        return Result.ok();
    }

    // 新增=================================================================
    @PostMapping("insert")
    public Result<String> insert(@RequestBody ScScore scScore){
        scScoreService.save(scScore);
        return Result.ok();
    }

    @GetMapping("{id}")
    public Result<ScScore> findById(@PathVariable Integer id){

        ScScore bean = scScoreService.getById(id);
        return Result.ok(bean);
    }

    // 修改----------------------------------------------------------------
    @PutMapping("update")
    public Result<ScScore> updateById(@RequestBody ScScore scScore){
        scScoreService.updateById(scScore);
        return Result.ok();
    }

    // 删除----------------------------------------------------------------
    @DeleteMapping("delete/{id}")
    public Result<ScScore> deleteById(@PathVariable Integer id){
        scScoreService.removeById(id);
        return Result.ok();
    }
}
