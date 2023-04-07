package com.changjiang.score.score.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("sc_score")
public class ScScore {

    /**
     * 成绩ID
     * */
    private Integer id;

    /**
     * 学生ID
     * */
    private Integer studentId;

    /**
     * 学生姓名
     * */
    private String studentName;

    /**
     * 课程ID
     * */
    private Integer courseId;

    /**
     * 课程名称
     * */
    private String courseName;

    /**
     * 班级ID
     * */
    private Integer classId;

    /**
     * 班级名称
     * */
    private String className;

    /**
     * 教师ID
     */
    private Integer teacherId;

    /**
     * 教师姓名
     */
    private String teacherName;

    /**
     * 成绩
     */
    private Integer score;

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

}
