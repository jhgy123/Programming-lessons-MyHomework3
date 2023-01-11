import entity.Student;
import org.junit.Test;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class MyJPQLQueryTest {
    @Test
    public void JpqQuery() {
        EntityManager manager = JPAUtil.getEntityManager();//开启一个实体管理器
        EntityTransaction tx = manager.getTransaction();//获取事务对象
        tx.begin();//开启事务
        //查询性别为男（true)并且学号在2020005至2020010之间的学生对象
        String jpql = "select s from " + "Student" + " as s where s.sex=true and s.id between 2020005 and 2020010";//编写JPQL语句
        Query query = manager.createQuery(jpql);//根据jpql语句创建Query查询对象
        List<Student> list = query.getResultList();//获取查询对象结果集
        for (Student stu : list) {//结果展示
            System.out.println("("+"学号:"+stu.getId()+"姓名："+stu.getName()+"性别："+stu.getSex()+"所学课程号："+stu.getCourseid()+")");
        }
        tx.commit();//提交事务
        manager.close();//释放资源
    }
}