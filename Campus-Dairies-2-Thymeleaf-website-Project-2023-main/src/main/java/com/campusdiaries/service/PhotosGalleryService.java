package com.campusdiaries.service;

import com.campusdiaries.entity.PhotosGallery;
import java.util.List;

public interface PhotosGalleryService { 

  List<PhotosGallery> getAllPhotosGallery();

PhotosGallery loadPhotosGalleryById(Integer id );

PhotosGallery createOrUpdatePhotosGallery(PhotosGallery photosGallery);

void removePhotosGallery(Integer id);

} 
