package entity;

import javax.persistence.*;

@Entity //将Student类映射到数据库中
@Table(name = "Students_Inf")//重命名表名
public class Student {
    @Id//设置主键
    @Column(name = "学号", length = 32)//重命名字段名字、设置字段的最大长度
    private long id;
    @Column(name = "姓名", length = 32)//重命名字段名字、设置字段的最大长度
    private String name;
    @Column(name = "性别")
    private Boolean sex;
    @Column(name = "所学的课程号", length = 32)//重命名字段名字、设置字段的最大长度
//    @OneToOne(targetEntity = Course.class)//设置对应的实体类的类型
//    @JoinColumn(name = "s_courseid", referencedColumnName = "courseid")//设置外键
    private long courseid;
//get、set方法
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public long getCourseid() {
        return courseid;
    }

    public void setCourseid(long courseid) {
        this.courseid = courseid;
    }
}
