package com.codegym.uploadimagecloudinary.controller;


import com.codegym.uploadimagecloudinary.model.image;
import com.codegym.uploadimagecloudinary.service.IImgService;
import com.codegym.uploadimagecloudinary.service.impl.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.awt.*;
import java.util.Date;

@RestController
@CrossOrigin("*")
public class imgController {
    @Autowired
    private CloudinaryService cloudinaryService;
    @Autowired
    private IImgService imgService;
    @RequestMapping("/all")
    public ResponseEntity<image> findAll(){
        return new ResponseEntity(imgService.findAll(), HttpStatus.OK);
    }
    @PostMapping("upload")
    public ResponseEntity<Image> upload(@RequestParam("image") MultipartFile file) {
        if(!file.isEmpty()) {
            String url = cloudinaryService.UploadFile(file);
            System.out.println(url);
            image img = new image();
            img.setPath(url);
            img.setDate(new Date());
            imgService.save(img);
            return new ResponseEntity(HttpStatus.OK);
        }else{ return new ResponseEntity(HttpStatus.NO_CONTENT);}
    }
}
