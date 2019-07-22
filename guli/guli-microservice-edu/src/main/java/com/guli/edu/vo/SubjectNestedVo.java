package com.guli.edu.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zheng
 * @Date: 2019/7/22
 * @Description:
 */
@Data
public class SubjectNestedVo implements Serializable {
    private String id;
    private String title;
    private List<SubjectVo> children = new ArrayList<>();
}
