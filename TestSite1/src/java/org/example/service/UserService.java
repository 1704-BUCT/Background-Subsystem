package org.example.service;

import org.example.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

//import java.awt.print.Pageable;
import java.util.List;

/*
 * 定义了服务的所有接口
 */

public interface UserService {
    public void save(User u)throws Exception;
//    public void save(User u);
    public Page<User> findAll(String kw, Pageable pageable);
    public User findById(Integer uid);
    public void deleteById(Integer uid);
    public void deletes(List<User> users);
}
