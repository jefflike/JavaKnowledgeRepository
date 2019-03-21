package com.jeff_code;

/**
 * @Author: jefflike
 * @create: 2018/10/16
 * @describe:
 */
public class emp {
    private Integer id;
    private String name;
    private Integer age;
    private Integer deptId;
    private Integer empno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    @Override
    public String toString() {
        return getName() + " in " + getDeptId();
    }
}
