package org.example.dao;

import org.example.domain.User;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {
    //通过属性的名称来定义方法
    //而此时Keyword在user表中没有，需要自定义查询方法
    @Query("select u from User u where u.account like ?1 or u.name like ?1 or u.email like ?1 or u.mobile like?1")
    public Page<User> findByKeyword(String kw, Pageable pageable);//自动分页

    @Query("update User u set u.password=?1 where u.uid=?2")//?1表示第一个参数，?2表示第二个参数
    public void modifiyPassword(String pwd,Integer uid);

}
