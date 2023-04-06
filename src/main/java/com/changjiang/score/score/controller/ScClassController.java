package com.changjiang.score.score.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.changjiang.score.common.Result;
import com.changjiang.score.score.entity.ScClass;
import com.changjiang.score.score.service.IScClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author XGLins
 * @date 2023/4/5 23:31
 */
@RestController
@RequestMapping("/score/scClass")
public class ScClassController {

    //自动装配
    @Autowired
    private IScClassService scClassService;

    @GetMapping("list")
    public Result<Page<ScClass>> list(Page<ScClass> page, ScClass scClass) {
        System.out.println(page.getSize());
        System.out.println(scClass);
        QueryWrapper<ScClass> query = Wrappers.query(scClass);

        Page<ScClass> pageRes = scClassService.page(page, query);
        System.out.println("查询结果" + pageRes.getRecords());
        return Result.ok(pageRes);
//        return Result.ok();
    }

    // 新增=================================================================
    @PostMapping("insert")
    public Result<Integer> insert(@RequestBody ScClass scClass){
        scClassService.save(scClass);
        return Result.ok();
    }

    @GetMapping("{id}")
    public Result<ScClass> findById(@PathVariable Integer id){

        ScClass bean = scClassService.getById(id);
        return Result.ok(bean);
    }

    // 修改----------------------------------------------------------------
    @PutMapping("update")
    public Result<ScClass> updateById(@RequestBody ScClass scClass){
        scClassService.updateById(scClass);
        return Result.ok();
    }

    // 删除----------------------------------------------------------------
    @DeleteMapping("delete/{id}")
    public Result<ScClass> deleteById(@PathVariable Integer id){
        scClassService.removeById(id);
        return Result.ok();
    }
}
