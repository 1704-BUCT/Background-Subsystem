package org.example.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity /*表明是实体*/
//实体是一切的开始，有了实体，表明数据库里有对应的表，表有对应的字段，可以进行增删改查
@Table(name="users")/*若没有表的话会自动创建表*/
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    @Column(length=30,unique = true)
    @NotNull
    private String account;
    @Column(length = 30)
    @NotNull
    private String password;
    @Column(length = 30)
    private String name;
    @Column(length = 10)
    private String grander;
    private LocalDateTime birthday;
    @Column(length = 11)
    private String mobile;
    private String email;
    private Integer lasttime;//最后登陆时间
    private Integer logincount;//登录次数
    private Integer validstate=1;//用户是否有效,0表示无效，1表示有效

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrander() {
        return grander;
    }

    public void setGrander(String grander) {
        this.grander = grander;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLasttime() {
        return lasttime;
    }

    public void setLasttime(Integer lasttime) {
        this.lasttime = lasttime;
    }

    public Integer getLogincount() {
        return logincount;
    }

    public void setLogincount(Integer logincount) {
        this.logincount = logincount;
    }

    public Integer getValidstate() {
        return validstate;
    }

    public void setValidstate(Integer validstate) {
        this.validstate = validstate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUid().equals(user.getUid()) &&
                Objects.equals(getAccount(), user.getAccount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid(), getAccount());
    }

}
