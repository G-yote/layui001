package com.kgc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

@Controller
public class UploadFileController {


    @Autowired
    private ServletContext servletContext;

    @RequestMapping("uploadFileOne")
    @ResponseBody
    public Map upload(MultipartFile file) throws Exception {
        String path = servletContext.getRealPath("/upload");
        File dir = new File(path);
        if (!dir.exists()) dir.mkdir();
        String fileName = System.currentTimeMillis() + file.getOriginalFilename();
        file.transferTo(new File(path + "\\" + fileName));

        Map map = new HashMap();
        map.put("msg", "上传成功");
        map.put("path", fileName);
        return map;
    }


    //处理批量上传
    @RequestMapping("uploadFile")
    @ResponseBody
    public Map uploadFile2(HttpServletRequest request) throws Exception {
        // 创建一个通用的多部分解析器
        Map map = new HashMap();

        String dirPath = servletContext.getRealPath("/upload");
        File dir = new File(dirPath);
        if (!dir.exists()) dir.mkdir();

        List<String> list = new ArrayList<String>();

        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());

        if (multipartResolver.isMultipart(request)) {
            // 转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            // get the parameter names of the multipart files contained in this request
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                // 取得上传文件
                List<MultipartFile> multipartFiles = multiRequest.getFiles(iter.next());

                for (MultipartFile multipartFile : multipartFiles) {
                    String originalFilename = System.currentTimeMillis() + multipartFile.getOriginalFilename();
                    if (originalFilename != null) {
                        multipartFile.transferTo(new File(dirPath + "\\" + originalFilename));
                        list.add(dirPath + originalFilename);
                    }
                }
            }
        }
        map.put("code", 0);
        map.put("data", list);
        return map;
    }
}
