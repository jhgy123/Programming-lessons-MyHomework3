package entity;

import javax.persistence.*;

@Entity//将Course类映射到数据库中
@Table(name = "Courses_Inf")//重命名表名
public class Course {
    @Id//设置主键
    @Column(name = "课程号", length = 32)//重命名字段名字、设置字段的最大长度
    private long courseid;
    @Column(name = "课程名称", length = 32)//重命名字段名字、设置字段的最大长度
    private String coursename;
    @Column(name = "学时")//重命名字段名字
    private int time;
    @Column(name = "教师职工号", length = 32)//重命名字段名字、设置字段的最大长度
//    @OneToOne(targetEntity = Teacher.class)//设置对应的实体类的类型
//    @JoinColumn(name = "teacherid", referencedColumnName = "id")//设置外键
    private long teacherid;
    //get、set方法
    public long getCourseid() {
        return courseid;
    }

    public void setCourseid(long courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public long getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(long teacherid) {
        this.teacherid = teacherid;
    }
}
