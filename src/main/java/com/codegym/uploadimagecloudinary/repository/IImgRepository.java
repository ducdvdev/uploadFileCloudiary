package com.codegym.uploadimagecloudinary.repository;

import com.codegym.uploadimagecloudinary.model.image;
import org.springframework.data.repository.CrudRepository;

public interface IImgRepository extends CrudRepository<image,Long> {
}
