package org.example.service;

import org.example.dao.UserRepository;
import org.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import org.springframework.data.domain.Pageable;
//import java.awt.print.Pageable;
import java.util.List;

@Service    //告诉springboot这是一个服务类，让它自动扫描
public class UserServiceImpl  implements UserService{

    @Autowired//springboot自动地注入我们需要的实体类对象
    public UserRepository userRepository;

    @Override   //抽象方法
    public void save(User u) throws Exception {
        try {
            userRepository.save(u);
        }catch (Exception ex){
            throw ex;
        }
    }

    @Override
    public Page<User> findAll(String kw, Pageable pageable) {
        return userRepository.findByKeyword(kw, pageable);
    }

    @Override
    public User findById(Integer uid) {
        return userRepository.findById(uid).get();
    }

    @Override
    public void deleteById(Integer uid) {
        userRepository.deleteById(uid);
    }

    @Override
    @Transactional  //保证删除地完整性
    public void deletes(List<User> users) {
        for(User u: users){
            userRepository.delete(u);
        }
    }
}
