package com.guli.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.edu.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.guli.edu.form.CourseInfoForm;
import com.guli.edu.query.CourseQuery;
import com.guli.edu.vo.CoursePublishVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author
 * @since 2019-07-12
 */
public interface CourseService extends IService<Course> {
    /**
     * 保存课程和课程详情信息
     * @param courseInfoForm
     * @return 新生成的课程id
     */
    String saveCourseInfo(CourseInfoForm courseInfoForm);

    void updateCourseInfoById(CourseInfoForm courseInfoForm);
    CourseInfoForm getCourseInfoFormById(String id);
    void pageQuery(Page<Course> pageParam, CourseQuery courseQuery);
    void removeCourseById(String id);
    CoursePublishVo getCoursePublishVoById(String id);
    void publishCourseById(String id);
}
