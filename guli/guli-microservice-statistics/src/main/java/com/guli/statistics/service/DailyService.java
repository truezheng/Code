package com.guli.statistics.service;

import com.guli.statistics.entity.Daily;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 网站统计日数据 服务类
 * </p>
 *
 * @author zheng
 * @since 2019-07-23
 */
public interface DailyService extends IService<Daily> {
    void createStatisticsByDay(String day);

    Map<String, Object> getChartData(String begin, String end, String type);
}
