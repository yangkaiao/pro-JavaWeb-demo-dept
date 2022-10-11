package buba.com.cn.entity;
/*
* 部门表 实体类
* */
public class Department {
    private Integer deptId;//部门id
    private String deptNumber;//部门编号
    private String deptName;//部门项目
    private String province;//所属省份
    private Integer people_counting;//部门人数
    private String described;//描述

    public Department() {
    }

    public Department(Integer deptId, String deptNumber, String deptName, String province, Integer people_counting, String described) {
        this.deptId = deptId;
        this.deptNumber = deptNumber;
        this.deptName = deptName;
        this.province = province;
        this.people_counting = people_counting;
        this.described = described;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptNumber() {
        return deptNumber;
    }

    public void setDeptNumber(String deptNumber) {
        this.deptNumber = deptNumber;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getPeople_counting() {
        return people_counting;
    }

    public void setPeople_counting(Integer people_counting) {
        this.people_counting = people_counting;
    }

    public String getDescribed() {
        return described;
    }

    public void setDescribed(String described) {
        this.described = described;
    }

    @Override
    public String toString() {
        return "department{" +
                "deptId=" + deptId +
                ", deptNumber='" + deptNumber + '\'' +
                ", deptName='" + deptName + '\'' +
                ", province='" + province + '\'' +
                ", people_counting=" + people_counting +
                ", described='" + described + '\'' +
                '}';
    }
}
