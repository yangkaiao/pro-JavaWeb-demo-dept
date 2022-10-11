package buba.com.cn.service.Impl;

import buba.com.cn.dao.DeptDao;
import buba.com.cn.dao.impl.DeptDaoImpl;
import buba.com.cn.entity.Department;
import buba.com.cn.service.DeptService;

import java.util.List;

public class DeptServiceImpl implements DeptService {
    DeptDao deptDao = new DeptDaoImpl();
    @Override
    public int addDept(Department department) {
        return deptDao.addDept(department);
    }

    @Override
    public int delDept(Integer deptId) {
        return deptDao.delDept(deptId);
    }

    @Override
    public int upDept(Department department) {
        return deptDao.upDept(department);
    }

    @Override
    public Department findDepartmentByDeptId(Integer deptId) {
        return deptDao.findDepartmentByDeptId(deptId);
    }

    @Override
    public List<Department> findDepartments(Integer pageNo) {
        return deptDao.findDepartments(pageNo);
    }

    @Override
    public int DeptCount() {
        return deptDao.DeptCount();
    }
}
