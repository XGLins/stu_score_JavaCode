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
@TableName("sc_student")
public class ScStudent {

    /**
     * 主键ID
     * */
    private Integer id;

    /**
     * 学生姓名
     * */
    private String name;

    /**
     * 学生电话
     * */
    private String phone;

    /**
     * 头像
     * */
    private String avatar;

    /**
     * 班级ID
     * */
    private Integer classId;

    /**
     * 班级名称
     * */
    private String className;

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
