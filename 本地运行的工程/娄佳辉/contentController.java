package com.alibaba.controller;

import com.alibaba.domain.Content;
import com.alibaba.domain.ContentType;
import com.alibaba.domain.Search;
import com.alibaba.service.ContentService;
import com.alibaba.service.ContentTypeService;
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

@Controller
public class contentController {
    @Autowired
    public ContentService contentService;
    @Autowired
    public ContentTypeService contentTypeService;
    @RequestMapping("/listcontent")
    public String list(Search search, Model model, Pageable pageable){
        model.addAttribute("search",search);
        Page<Content> p = contentService.FindBySearch(search,pageable);
        model.addAttribute("pages",p);
        return "listcontent";
    }
    @GetMapping({"/editcontent","/editcontent/{cid}"})
    public String edit(@PathVariable(name="cid",required = false)Integer cid, Model model){
        Content c=null;
        if(cid==null){
            c=new Content();
        }else {
            c=contentService.findById(cid);
        }
        model.addAttribute("types",contentTypeService.findByParent(null));
        model.addAttribute("content",c);
        return "editcontent";
    }
    @PostMapping("/savecontent")
    public String save(@Valid Content content, BindingResult br, RedirectAttributes attr){
        ContentType ct=new ContentType();
        ct.setTid(9);
        content.setType(ct);
        contentService.save(content);
        attr.addFlashAttribute("ok","保存成功！");
        return "redirect:/editcontent";
    }
}
