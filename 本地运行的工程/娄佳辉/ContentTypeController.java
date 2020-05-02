package com.alibaba.controller;

import com.alibaba.domain.ContentType;
import com.alibaba.service.ContentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
@Controller
public class ContentTypeController {
    @Autowired
    private ContentTypeService contentTypeService;

    @GetMapping({"/edittype","/edittype/{tid}"})
    public String edit(@PathVariable(value = "tid",required = false)Integer tid, Model model){
        ContentType type=null;
        if(tid==null){
            type=new ContentType();
        }else {
            type = contentTypeService.findByid(tid);
        }
        model.addAttribute("contentype",type);
        return "edittype";
    }
    @PostMapping("/savetype")
    public String save(@Valid ContentType type, BindingResult result,Model model){
        model.addAttribute("contenttype",type);
        if(result.hasErrors()){
            //在界面上显示错误信息
        }
        contentTypeService.save(type);
        model.addAttribute("ok","保存成功");
        return "edittype";
    }

}
