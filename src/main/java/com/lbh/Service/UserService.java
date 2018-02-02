package com.lbh.Service;

import com.lbh.Dao.UserRepository;
import com.lbh.entity.User;
import com.lbh.enums.ResultEnum;
import com.lbh.handle.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Advancer on 2018/1/8 14:08.
 * auth: lbh
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    public void insertUsers(){
        User user = new User();
        user.setAge("24");
        user.setName("jkj");
        userRepository.save(user);

        User user1 = new User();
        user1.setAge("24");
        user1.setName("wyy");
        userRepository.save(user1);
    }

    public Integer getAge(Integer id) throws  Exception{
        User user = userRepository.findOne(id);
        Integer age = Integer.parseInt(user.getAge());
        if (age < 10){
            //...
            throw new UserException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age > 10 && age < 16){
            //...
            throw new UserException(ResultEnum.MIDDLE_SCHOOL);
        }
        // ..
        return 0;
    }

    /**
     * 测试通过id查询一个用户
     * @param id
     * @return
     */
    public User findUserById(Integer id){
        return userRepository.findOne(id);
    }

}
