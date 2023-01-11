package dao.Impl;

import dao.IBaseDao;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseDao<T> implements IBaseDao<T> {//对接口的实现
    private Class<T> clz;
    public BaseDao() {//获取到T的类型
        ParameterizedType parametclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = parametclass.getActualTypeArguments();
        clz = (Class<T>) actualTypeArguments[0];
    }
    @Override
    public void save(Object s) {//重写save()方法
        EntityManager manager = JPAUtil.getEntityManager();//开启一个实体管理器
        manager.getTransaction().begin();//事务开始
        manager.persist(s);//将要保存的对象持久化到数据库中
        manager.getTransaction().commit();//事务提交
        manager.close();
    }

    @Override
    public void update(Object s) {//重写update()方法
        EntityManager manager = JPAUtil.getEntityManager();//开启一个实体管理器
        manager.getTransaction().begin();//事务开始
        manager.merge(s);//将修改后的对象持久化到数据库中
        manager.getTransaction().commit();//事务提交
        manager.close();
    }

    @Override
    public void delete(Serializable i) {//重写delete()方法
        EntityManager manager = JPAUtil.getEntityManager();//开启一个实体管理器
        manager.getTransaction().begin();//事务开始
        T t = manager.find(clz, i);//按要求查找要删除的数据库记录的对象
        manager.remove(t);//将要删除的对象从数据库中删除
        manager.getTransaction().commit();//事务提交
        manager.close();
    }

    @Override
    public T getOne(Serializable i) {//重写getOne()方法
        EntityManager manager = JPAUtil.getEntityManager();//开启一个实体管理器
        return  manager.find(clz,i);//按要求查找要符合要求的数据库记录的对象，并返回对象

    }

    @Override
    public List getAll() {//重写getAll()方法
        EntityManager manager = JPAUtil.getEntityManager();//开启一个实体管理器
        String sql = "select p from "+ clz.getName() +" as p";//编写JPQL语句
        Query query = manager.createQuery(sql);//执行JPQL语句
        return query.getResultList();//返回结果集
    }

}
