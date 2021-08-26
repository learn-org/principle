package com.learn.entity;

import lombok.Data;
import lombok.ToString;
import java.io.Serializable;
import java.util.List;

/**
 * @author: lxj
 * @Date: 2021/5/19
 * @Description:
 */
@Data
@ToString
public class GetDeptTreeListResponse implements Serializable {
    private static final long serialVersionUID = -6485294025605859787L;
    private String parentDeptId;
    private String deptId;
    private String deptName;
    private List<GetDeptTreeListResponse> childDeptList;
}
