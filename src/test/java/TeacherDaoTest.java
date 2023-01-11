import dao.Impl.TeacherDao;
import entity.Teacher;
import org.junit.Test;

import java.util.List;

public class TeacherDaoTest {
    TeacherDao udao = new TeacherDao();//创建TeacherDao对象

    @Test
    public void testCreateTeacher(){//创建Teacher数据
        Teacher teacher = new Teacher();//创建Teacher对象
        teacher.setId(1999001L);//添加id
        teacher.setName("李华");//添加姓名
        teacher.setCourseid(100001L);//添加课程号
        udao.save(teacher);//保存对象，将对象映射到数据库中
    }

    @Test
    public void testUpdateTeacher(){//如果已经存在，则更新Teacher数据，如果不存在，则新增Teacher数据
        Teacher teacher = new Teacher();
        teacher.setId(1999001L);//若id存在，修改对象；若id不存在，新增对象
        teacher.setName("李华");//不变
        teacher.setCourseid(100002L);//修改课程号或新增课程号
        udao.update(teacher);//保存对象，将对象映射到数据库中

    }

    @Test
    public void testDeleteTeacher(){//删除Student数据
        udao.delete(1999001L);//根据id值删除对应的对象记录
    }

    @Test
    public  void GetTeacher(){//或取Student对象
        Teacher teacher = udao.getOne(1999001L);
    }

    @Test
    public void findAll(){//获取所有Teacher对象
        List<Teacher> list= udao.getAll();
        list.forEach(item->System.out.println(item.getName()+" "+item.getId()));
    }



}
