package com.campusdiaries.service.serviceImpl;

import java.util.List; 
import javax.persistence.EntityNotFoundException; 
import org.springframework.beans.factory.annotation.Autowired;
import com.campusdiaries.dao.PhotosGalleryDAO; 
import com.campusdiaries.entity.PhotosGallery; 
import com.campusdiaries.service.PhotosGalleryService; 
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PhotosGalleryServiceImpl implements PhotosGalleryService { 

@Autowired
 private PhotosGalleryDAO photosGalleryDao;
 
 @Override 
    public List<PhotosGallery> getAllPhotosGallery() { 
        return photosGalleryDao.findAll(); 
    } 

@Override 
  public PhotosGallery loadPhotosGalleryById(Integer id) {
 return photosGalleryDao.findById(id).orElseThrow(() -> new EntityNotFoundException("PhotosGallery with ID " + id + " Not Found"));
 }

@Override 
    public PhotosGallery createOrUpdatePhotosGallery(PhotosGallery photosGallery) {
return photosGalleryDao.save(photosGallery);
   }

  @Override
 	    public void removePhotosGallery(Integer id) {
 	        photosGalleryDao.deleteById(id);
 	    }

}
