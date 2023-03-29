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

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("sc_teacher")
/**
 * 教师-实体类
 * */
public class ScTeacher {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     * */
    private Integer id;

    /**
     * 教师姓名
     * */
    private String name;

    /**
     * 联系电话
     * */
    private String phone;

    /**
     * 头像
     * */
    private String avatar;

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
