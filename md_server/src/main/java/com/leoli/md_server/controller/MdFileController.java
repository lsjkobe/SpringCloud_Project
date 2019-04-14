package com.leoli.md_server.controller;

import com.leoli.md_server.controller.vo.MdFileVo;
import com.leoli.md_server.model.service.MdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MdFileController {

    @Autowired
    MdService<MdFileVo> mdService;

    @PostMapping("/api/v1/save/mdFile")
    @ResponseBody
    public Object save(@RequestBody MdFileVo mdFileVo){
        mdService.save(mdFileVo);
        return "success";
    }

    @GetMapping("/api/v1/get/mdFile/{id}")
    @ResponseBody
    public Object get(@PathVariable("id") String id){
        return mdService.findbyId(id);
    }
}
