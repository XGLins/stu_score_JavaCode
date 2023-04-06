package com.changjiang.score.score.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.changjiang.score.score.entity.ScStudent;
import com.changjiang.score.score.mapper.ScStudentMapper;
import com.changjiang.score.score.service.IScStudentService;
import org.springframework.stereotype.Service;

/**
 * 学生信息 服务实现类
 * */
@Service
public class ScStudentServiceImpl extends ServiceImpl<ScStudentMapper, ScStudent> implements IScStudentService {
}
