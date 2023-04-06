package com.changjiang.score.score.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.changjiang.score.score.entity.ScCourse;
import com.changjiang.score.score.mapper.ScCourseMapper;
import com.changjiang.score.score.service.IScCourseService;
import org.springframework.stereotype.Service;

/**
 * 学生课表 服务实现类
 * */
@Service
public class ScCourseServiceImpl extends ServiceImpl<ScCourseMapper, ScCourse> implements IScCourseService {
}
