package org.example.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.example.dao.UserRepository;
import org.example.domain.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

//import java.awt.print.Pageable;

/*
 * 决定跳转到那个页面
 * controller类的作用是处理数据
 */

/*
* Spring MVC Controller：
* 查询所有地符合条件地用户信息，并分页传送给页面
* 编辑方法从数据库中查询需要地数据
* 存储方法把当前新增的用户或编辑后的用户信息存储到数据库
* 删除数据库
* 锁定用户，有效状态
* 备份数据库
* 恢复数据库
* 生成管理日志，并可以返回给前台
* */

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /*
    * 根据条件查询用户信息
    * @param kw 查询关键字即条件
    * @param model 模型对象，也就是视图（界面）的上下文
    * @param pageable 分页信息，包含了分页需要的基本信息，如当前页号
    * return 字符串，代表了界面文件
    * */
    @RequestMapping("/listusers")//"/listusers"是路径
    public String list(String kw, Model model, Pageable pageable){
        model.addAttribute("kw",kw);
        if(kw!=null) kw='%'+kw+'%';
        else kw="%%";
        Page<User> ppu = userService.findAll(kw, pageable);
        model.addAttribute("pages",ppu);
        return "listusers";//返回界面名称
    }

    @GetMapping({"/edituser","/edituser/{uid}"})
    public String edit(@PathVariable(value = "uid", required =false)Integer uid,Model model){
        User u = new User();
        if(uid!=null&&uid>0){
            u = userService.findById(uid);
        }
        model.addAttribute("user",u);
        return "edituser";
    }

    @PostMapping("/saveuser")
    public String save(@Valid User user, BindingResult result, RedirectAttributes attr){
        try {
            if (result.hasErrors()) {
                System.out.println(result.getFieldError().toString());
                return "redirect:/edituser";
            }
            if(user.getUid()!=null && user.getUid()>0){
                User u = userService.findById(user.getUid());
                user.setPassword(u.getPassword());
            }
            userService.save(user);
            attr.addFlashAttribute("ok","保存成功");
            return "redirect:/listusers";
        }catch (Exception ex){
            return "redirect:/edituser";
        }
    }

    @GetMapping("/deleteuser/{uid}")
    //@PathVariable保证uid不为空
    public String delete(@PathVariable("uid")Integer uid){
        userService.deleteById(uid);
        return "redirect:/listusers";
    }

    @PostMapping("/deleteusers")
    public String deletes(String uids){
        List<User> users = new ArrayList<>();
        JSONObject json=JSONObject.parseObject(uids);
        //得到json的id集合
        JSONArray arr = json.getJSONArray("uids");
        int ilen = arr.size();
        for(int i=0;i<ilen;i++){//每次循环ilen次来执行ilen个查询，再去删除
            users.add(userService.findById(arr.getInteger(i)) );
        }
        userService.deletes(users);
        return "redirect:/listusers";
    }

    @GetMapping("/validuser/{uid}")
    public String validuser(@PathVariable("uid")Integer uid){
        User user = userService.findById(uid);
//        if(user.getValidstate()==0) user.setValidstate(1);//当无效时，设置用户状态为有效
//        if(user.getValidstate()==1) user.setValidstate(0);
          user.setValidstate(1-user.getValidstate());
          return "redirect:/listusers";
    }

}
