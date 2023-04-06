package com.changjiang.score.score.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 班级-实体类
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("sc_class")
public class ScClass {

    /**
     * 主键ID
     * */
    private Integer id;

    /**
     * 班级名称
     * */
    private String name;

    /**
     * 创建时间
     * */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改时间
     * */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    /**
     * 0-正常，1-删除
     * */
    @TableLogic
    private String delFlag;
}
