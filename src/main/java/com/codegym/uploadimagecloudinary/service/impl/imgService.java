package com.codegym.uploadimagecloudinary.service.impl;

import com.codegym.uploadimagecloudinary.model.image;
import com.codegym.uploadimagecloudinary.repository.IImgRepository;
import com.codegym.uploadimagecloudinary.service.IImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class imgService implements IImgService {
    @Autowired
    private IImgRepository imgRepository;
    @Override
    public List<image> findAll() {
        return (List<image>) imgRepository.findAll();
    }

    @Override
    public void save(image image) {
        imgRepository.save(image);
    }

    @Override
    public void delete(long id) {
        imgRepository.deleteById(id);
    }

    @Override
    public image findById(long id) {
        return imgRepository.findById(id).get();
    }
}
