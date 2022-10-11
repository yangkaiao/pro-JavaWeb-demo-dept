package buba.com.cn.dao.impl;

import buba.com.cn.utils.JDBCUtils;
import buba.com.cn.dao.DeptDao;
import buba.com.cn.entity.Department;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class DeptDaoImpl implements DeptDao {

    @Override
    public int addDept(Department department) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "INSERT INTO department values(?,?,?,?,?,?)";
        int update = jdbcTemplate.update(sql, department.getDeptId(), department.getDeptNumber(), department.getDeptName(), department.getProvince(), department.getPeople_counting(), department.getDescribed());
        return update;
    }

    @Override
    public int delDept(Integer deptId) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "delete from department where dept_id = ?";
        int update = jdbcTemplate.update(sql, deptId);
        return update;
    }

    @Override
    public int upDept(Department department) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "update department set dept_number=?,dept_name=?,province=?,people_counting=?,described=? where dept_id=?";
        int update = jdbcTemplate.update(sql, department.getDeptNumber(), department.getDeptName(), department.getProvince(), department.getPeople_counting(), department.getDescribed(),department.getDeptId());
        return update;
    }

    @Override
    public Department findDepartmentByDeptId(Integer deptId) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "select * from department where dept_id = ?";
        Department department = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Department.class), deptId);


        return department;
    }

    @Override
    public List<Department> findDepartments(Integer pageNo) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "select * from department limit ? , 5";
        List<Department> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Department.class),(pageNo-1)*5);
        return query;
    }

    @Override
    public int DeptCount() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDateSource());
        String sql = "select count(*) from department";
        Integer integer = jdbcTemplate.queryForObject(sql, Integer.class);
        return integer;
    }
}
