package com.lbh.Dao;

import com.lbh.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Advancer on 2017/12/29 10:41.
 * auth: lbh
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    //通过年龄来查询数据
    public List<User> findUserByAge(String age);

}
