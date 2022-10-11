package buba.com.cn.dao;

import buba.com.cn.entity.Department;

import java.util.List;

public interface DeptDao {
    //增加
    int addDept(Department department);

    //删除
    int delDept(Integer deptId);

    //修改
    int upDept(Department department);

    //根据员工编号查询员工信息
    Department findDepartmentByDeptId(Integer deptId);

    //查找分页查询数据
    List<Department> findDepartments(Integer pageNo);

    //统计表中有多少条数据
    int DeptCount();
}
