package com.learn.utils;

import com.learn.entity.GetDeptTreeListResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author: lxj
 * @Date: 2021/5/21
 * @Description:
 */

public class DeptTreeUtil {
    /**
     * 构建树形结构
     * @param deptList
     * @return
     */
    public List<GetDeptTreeListResponse> buildTree(List<GetDeptTreeListResponse> deptList) {
        List<GetDeptTreeListResponse> treeDeptList = new ArrayList<>();
        List<GetDeptTreeListResponse> rootDeptList = getRootDept(deptList);
        for (GetDeptTreeListResponse rootDept : rootDeptList) {
            buildChildDept(rootDept, deptList);
            treeDeptList.add(rootDept);
        }
        return treeDeptList;
    }

    /**
     * 递归子部门
     * @param dept
     * @param deptList
     */
    public void buildChildDept(GetDeptTreeListResponse dept, List<GetDeptTreeListResponse> deptList) {
        List<GetDeptTreeListResponse> childDeptList = getChildDept(dept, deptList);
        if (!childDeptList.isEmpty()) {
            for (GetDeptTreeListResponse childDept : childDeptList) {
                buildChildDept(childDept, deptList);
            }
            dept.setChildDeptList(childDeptList);
        }
    }

    /**
     * 获取部门下所有的子部门
     * @param parentDept
     * @param deptList
     * @return
     */
    public List<GetDeptTreeListResponse> getChildDept(GetDeptTreeListResponse parentDept, List<GetDeptTreeListResponse> deptList) {
        List<GetDeptTreeListResponse> childDeptList = new ArrayList<>();
        for (GetDeptTreeListResponse n : deptList) {
            if (Objects.equals(parentDept.getDeptId(), n.getParentDeptId())) {
                childDeptList.add(n);
            }
        }
        return childDeptList;
    }

    /**
     * 判断是否为根部门
     * @param dept
     * @param deptList
     * @return
     */
    public boolean isRootDept(GetDeptTreeListResponse dept, List<GetDeptTreeListResponse> deptList) {
        boolean isRootDept = true;
        for (GetDeptTreeListResponse n : deptList) {
            if (Objects.equals(dept.getParentDeptId(), n.getDeptId())) {
                isRootDept = false;
                break;
            }
        }
        return isRootDept;
    }

    /**
     * 获取所有的根部门
     * @param deptList
     * @return
     */
    public List<GetDeptTreeListResponse> getRootDept(List<GetDeptTreeListResponse> deptList) {
        List<GetDeptTreeListResponse> rootDeptList = new ArrayList<>();
        for (GetDeptTreeListResponse n : deptList) {
            if (isRootDept(n, deptList)) {
                rootDeptList.add(n);
            }
        }
        return rootDeptList;
    }

    /**
     * 获取所有子孙部门
     * @param parentDept
     * @param childDeptList
     * @param deptList
     */
    public void getAllChildDept(GetDeptTreeListResponse parentDept, List<GetDeptTreeListResponse> childDeptList, List<GetDeptTreeListResponse> deptList) {
        for (GetDeptTreeListResponse n : deptList) {
            if (Objects.equals(parentDept.getDeptId(), n.getParentDeptId())) {
                childDeptList.add(n);
                getAllChildDept(n, childDeptList, deptList);
            }
        }
    }

    /**
     * 获取所有父部门
     * @param dept
     * @param parentDeptList
     * @param deptList
     */
    public void getAllParentDept(GetDeptTreeListResponse dept, List<GetDeptTreeListResponse> parentDeptList, List<GetDeptTreeListResponse> deptList) {
        for (GetDeptTreeListResponse n : deptList) {
            if (Objects.equals(dept.getParentDeptId(), n.getDeptId())) {
                parentDeptList.add(n);
                getAllChildDept(n, parentDeptList, deptList);
            }
        }
    }

    /**
     * 获取树形结构的每个节点
     * @param getDeptTreeListResponse
     * @param getDeptTreeListResponseList
     */
    public void getRecursionDept(GetDeptTreeListResponse getDeptTreeListResponse, List<GetDeptTreeListResponse> getDeptTreeListResponseList) {
        if (getDeptTreeListResponse.getChildDeptList() != null && getDeptTreeListResponse.getChildDeptList().size() > 0) {
            for (GetDeptTreeListResponse g : getDeptTreeListResponse.getChildDeptList()) {
                getDeptTreeListResponseList.add(g);
                getRecursionDept(g, getDeptTreeListResponseList);
            }
        }
    }

}
