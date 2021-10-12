package com.codegym.uploadimagecloudinary.service;

import com.codegym.uploadimagecloudinary.model.image;

import java.util.List;

public interface IImgService {
    List<image> findAll();
    void save(image image);
    void delete(long id);
    image findById(long id);
}
