import dao.Impl.StudentDao;
import entity.Student;
import org.junit.Test;

import java.util.List;

public class StudentDaoTest {//StudentDao的测试程序
    StudentDao udao = new StudentDao();//创建StudentDao对象

    @Test
    public void testCreateStudent(){//创建Student数据
        Student student = new Student();//创建Student对象
        student.setId(2020001L);//添加id
        student.setName("tom");//添加姓名
        student.setSex(true);//添加性别
        student.setCourseid(100001L);//添加课程号
        udao.save(student);//保存对象，将对象映射到数据库中
    }

    @Test
    public void testUpdateStudent(){//如果已经存在，则更新Student数据，如果不存在，则新增Student数据
        Student student = new Student();
        student.setId(2020001L);//若id存在，修改对象；若id不存在，新增对象
        student.setName("汤姆");//修改姓名或新增姓名
        student.setSex(true);//不变
        student.setCourseid(100001L);//不变
        udao.update(student);//保存对象，将对象映射到数据库中

    }

    @Test
    public void testDeleteStudent(){//删除Student数据
        udao.delete(2020001L);//根据id值删除对应的对象记录
    }

    @Test
    public  void GetStudent(){//或取Student对象
        Student student = udao.getOne(2020001L);
    }

    @Test
    public void findAll(){//获取所有Student对象
        List<Student> list= udao.getAll();
        list.forEach(item->System.out.println(item.getName()+" "+item.getId()));
    }



}
