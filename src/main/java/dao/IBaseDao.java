package dao;

import java.io.Serializable;
import java.util.List;
//接口定义
public interface IBaseDao<T> {
    void save(T s);//保存记录的方法
    void update(T s);//更新记录的方法
    void delete(Serializable i);//删除记录的方法
    T getOne(Serializable i);//获取一条记录的方法
    List<T> getAll();//获取全部记录的方法
}
