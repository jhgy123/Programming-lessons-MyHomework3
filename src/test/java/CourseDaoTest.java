import dao.Impl.CourseDao;
import entity.Course;
import org.junit.Test;

import java.util.List;

public class CourseDaoTest {
    CourseDao udao = new CourseDao();//创建CourseDao对象

    @Test
    public void testCreateCourse(){//创建Course数据
        Course course = new Course();//创建Course对象
        course.setCourseid(100001L);//添加Courseid
        course.setCoursename("高等数学");//添加课程名
        course.setTime(36);//添加学时
        course.setTeacherid(1999001L);//添加教师号
        udao.save(course);//保存对象，将对象映射到数据库中
    }

    @Test
    public void testUpdateCourse(){//如果已经存在，则更新Course数据，如果不存在，则新增Course数据
        Course course = new Course();
        course.setCourseid(100001L);//若Courseid存在，修改对象；若Courseid不存在，新增对象
        course.setCoursename("高等数学(上)");//修改课程名或新增课程名
        course.setTime(36);//不变
        course.setTeacherid(1999001L);//不变
        udao.update(course);//保存对象，将对象映射到数据库中

    }

    @Test
    public void testDeleteCourse(){//删除Course数据
        udao.delete(100001L);//根据id值删除对应的对象记录
    }
    @Test
    public  void GetCourse(){//或取Course对象
        Course student = udao.getOne(100001L);
    }
    @Test
    public void findAll(){//获取所有Course对象
        List<Course> list= udao.getAll();
        list.forEach(item->System.out.println(item.getCoursename()+" "+item.getCourseid()));
    }
}
