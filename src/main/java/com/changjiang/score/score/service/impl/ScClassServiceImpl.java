package com.changjiang.score.score.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.changjiang.score.score.entity.ScClass;
import com.changjiang.score.score.mapper.ScClassMapper;
import com.changjiang.score.score.service.IScClassService;
import org.springframework.stereotype.Service;

/**
 * 班级信息表 服务实现类
 * */
@Service
public class ScClassServiceImpl extends ServiceImpl<ScClassMapper, ScClass> implements IScClassService {
}
