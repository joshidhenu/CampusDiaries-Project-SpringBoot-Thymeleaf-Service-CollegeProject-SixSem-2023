package com.campusdiaries.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import com.campusdiaries.entity.PhotosGallery;

public interface PhotosGalleryDAO extends JpaRepository<PhotosGallery, Integer> { 

} 
