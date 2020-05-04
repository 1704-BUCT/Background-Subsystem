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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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
    @RequestMapping("/uploadAudio")
    @ResponseBody
    public void uploadAudio(@RequestParam("upload")MultipartFile file){
        if(!file.isEmpty()){
            String filename=file.getOriginalFilename();
            System.out.println("Load fn:"+filename);
            //System.out.println("Load uploadfile:" + fname)
            try {

                String fileurl = "D:\\/" + filename;//存储路径如发生改变应相应改变
                File f = new File(fileurl);
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(f));
                if (!f.exists()) {
                    try {
                        f.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("上传失败，因为文件是空的.");

        }
    }
}
