package com.changjiang.score.score.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.changjiang.score.score.entity.ScScore;
import com.changjiang.score.score.mapper.ScScoreMapper;
import com.changjiang.score.score.service.IScScoreService;
import org.springframework.stereotype.Service;

/**
 * 成绩信息表 服务实现类
 * */
@Service
public class ScScoreServiceImpl extends ServiceImpl<ScScoreMapper, ScScore> implements IScScoreService {
}
