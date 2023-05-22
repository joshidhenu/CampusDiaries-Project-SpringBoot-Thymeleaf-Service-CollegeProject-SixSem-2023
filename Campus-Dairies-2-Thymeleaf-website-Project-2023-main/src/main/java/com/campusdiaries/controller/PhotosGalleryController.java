package com.campusdiaries.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.campusdiaries.entity.Event;
import com.campusdiaries.entity.PhotosGallery;
import com.campusdiaries.service.EventService;
import com.campusdiaries.service.PhotosGalleryService;
import com.campusdiaries.util.FileUploadUtil;
import com.campusdiaries.util.Helper;

@Controller
@RequestMapping(value = "photosGallery")
public class PhotosGalleryController {
	private PhotosGalleryService photosGalleryService;
	private EventService eventService;

	public PhotosGalleryController(PhotosGalleryService photosGalleryService, EventService eventService) {
		this.photosGalleryService = photosGalleryService;
		this.eventService = eventService;
	}

	@GetMapping(value = "/index")
	public String photosGalleries(Model model, @RequestParam(name = "keyword", defaultValue = "") String keyword) {
		if(!Helper.checkSession()) { return "redirect:/login";}
		
		List<PhotosGallery> photosGalleries = photosGalleryService.getAllPhotosGallery();
		model.addAttribute("listPhotosGalleries", photosGalleries);
		model.addAttribute("keyword", keyword);
		return "admin/list/photosGalleries_list";
	}

	@GetMapping(value = "/create")
	public String formPhotosGalleries(Model model) {
		if(!Helper.checkSession()) { return "redirect:/login";}
		
		model.addAttribute("photosGallery", new PhotosGallery());
		List<Event> events = eventService.getAllEvent();
		model.addAttribute("listEvents", events);

		return "admin/entry/photosGallery_entry";
	}

	@GetMapping(value = "/delete/{id}")
	public String deletePhotosGallery(@PathVariable(value = "id") Integer id, String keyword) {
		if(!Helper.checkSession()) { return "redirect:/login";}
		
		photosGalleryService.removePhotosGallery(id);
		return "redirect:/photosGallery/index?keyword=" + keyword;
	}

	@GetMapping(value = "/update/{id}")
	public String updatePhotosGallery(@PathVariable(value = "id") Integer id, Model model) {
		if(!Helper.checkSession()) { return "redirect:/login";}
		
		PhotosGallery photosGallery = photosGalleryService.loadPhotosGalleryById(id);
		model.addAttribute("photosGallery", photosGallery);
		List<Event> events = eventService.getAllEvent();
		model.addAttribute("listEvents", events);

		return "admin/edit/photosGallery_edit";
	}

	@PostMapping(value = "/save")
	public String save(PhotosGallery photosGallery,@RequestParam("file") MultipartFile file) throws IOException  {
		if(!Helper.checkSession()) { return "redirect:/login";}
		
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    if(fileName.length()>3) {
		photosGallery.setPhoto(fileName);
		photosGalleryService.createOrUpdatePhotosGallery(photosGallery);
	    String uploadDir = "assets1/images/photos";
	    FileUploadUtil.saveFile(uploadDir, fileName,file);
	    }else {
		photosGalleryService.createOrUpdatePhotosGallery(photosGallery);
	    }
	    
		return "redirect:/photosGallery/index";
	}

}
