package com.campusdiaries.controller.user;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.campusdiaries.entity.Event;
import com.campusdiaries.entity.EventRegistration;
import com.campusdiaries.entity.Feedback;
import com.campusdiaries.entity.PhotosGallery;
import com.campusdiaries.entity.Post;
import com.campusdiaries.entity.Suggestion;
import com.campusdiaries.entity.User;
import com.campusdiaries.service.EventRegistrationService;
import com.campusdiaries.service.EventService;
import com.campusdiaries.service.FeedbackService;
import com.campusdiaries.service.PhotosGalleryService;
import com.campusdiaries.service.PostService;
import com.campusdiaries.service.SuggestionService;
import com.campusdiaries.service.UserService;
import com.campusdiaries.util.FileUploadUtil;
import com.campusdiaries.util.Helper;

@Controller

public class HomeController {
	private SuggestionService suggestionService;

	private PhotosGalleryService photosGalleryService;

	private EventService eventService;
	private EventRegistrationService eventRegistrationService;

	private PostService postService;

	private FeedbackService feedbackService;

	private UserService userService;

	public HomeController(SuggestionService suggestionService, EventService eventService,
			PhotosGalleryService photosGalleryService, PostService postService, FeedbackService feedbackService,
			UserService userService, EventRegistrationService eventRegistrationService) {
		super();
		this.suggestionService = suggestionService;
		this.photosGalleryService = photosGalleryService;
		this.eventService = eventService;
		this.postService = postService;
		this.feedbackService = feedbackService;
		this.userService = userService;
		this.eventRegistrationService = eventRegistrationService;
	}

	public void removeVerificationMessageFromSession() {

		try {
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
					.getRequest();
			HttpSession session = request.getSession();
			session.removeAttribute("verificationMessage");
		} catch (RuntimeException ex) {
			System.out.println("No Request: " + ex);
		}
	}

	@GetMapping("/about")
	public String showAbout() {

		return "user/about";
	}

	@GetMapping("/")
	public String name(Model m) {
		List<Post> listPost = postService.getAllPost().subList(0, 3);
		m.addAttribute("listPost", listPost);

		List<Event> listEvent = eventService.findAllByStartDate(new Date());
		m.addAttribute("listEvent", listEvent);

		List<PhotosGallery> listPhotosGallery = photosGalleryService.getAllPhotosGallery();
		m.addAttribute("listPhotosGallery", listPhotosGallery);

		List<PhotosGallery> listPhotosGallery2 = photosGalleryService.getAllPhotosGallery();
		m.addAttribute("listPhotosGallery2", listPhotosGallery2);

		return "user/index";
	}

	@GetMapping("/log-out")
	public String logoutForm() {

		return "/user/logout";
	}

	@GetMapping("/logout")
	public String logout() {

		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();

		if (session.getAttribute("uname") != null)
			session.removeAttribute("uname");

		if (session.getAttribute("uid") != null)
			session.removeAttribute("uid");

		if (session.getAttribute("urole") != null)
			session.removeAttribute("urole");

		return "redirect:/login";
	}

	@GetMapping("/login")
	public String login() {
		return "/user/login";
	}

	@PostMapping("/login")
	public String CheckLogin(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {

		User user = userService.getUserByEmailandPassword(email, password);
		if (user != null) {
			session.setAttribute("uname", user.getName());
			session.setAttribute("uid", user.getId());
			session.setAttribute("urole", user.getRole());
			System.out.println("xxxxxxxxxxxxx");
			System.out.println(user);
			System.out.println("xxxxxxxxxxxxx");

			session.setAttribute("msg", "Login Successfully...");
			
			if(user.getRole().equalsIgnoreCase("admin") ||user.getRole().equalsIgnoreCase("staff") )
				return "redirect:/dashboard";
			else
				return "redirect:/";
			
		} else

		{
			session.setAttribute("msg", "Wrong Username or Password...");
			return "redirect:/login";
		}

	}

	@GetMapping("/like/{id}")
	public String like(@PathVariable("id")int id, HttpSession session) {
		Post post =  postService.loadPostById(id);
		post.setLikeCount(post.getLikeCount()+1);
		postService.createOrUpdatePost(post);
		session.setAttribute("msg", "Liked..");
		return "redirect:/post";
	}


	@GetMapping("/dislike/{id}")
	public String dislike(@PathVariable("id")int id, HttpSession session) {
		Post post =  postService.loadPostById(id);
		post.setDislikeCount(post.getDislikeCount()+1);
		postService.createOrUpdatePost(post);
		session.setAttribute("msg", "Disliked..");
		return "redirect:/post";
	}
	@GetMapping("/register")
	public String register() {

		return "/user/register";
	}

	@PostMapping("/register")
	public String register(@ModelAttribute User user, HttpSession session) {

		if (userService.checkEmailExist(user.getEmail())) {
			session.setAttribute("msg", "Email Already exist..");

		} else {
			user.setName("Test");
			user.setRole("USER");
			user.setEntryDate(new Date());
			user.setLogoutDate(new Date());
			user.setStatus("1");

			session.setAttribute("msg", "Registration Completed successfully..");
			userService.createOrUpdateUser(user);
		}
		return "/user/register";
	}

	@GetMapping("/forgot-password")
	public String forgotpassword() {

		return "/user/forgot-password";

	}

	@GetMapping("/suggestion")
	public String showSuggestion(Model m, Suggestion suggestion) {
		List<Suggestion> listSuggestion = suggestionService.getAllSuggestion();
		m.addAttribute("listSuggestion", listSuggestion);

		List<PhotosGallery> listPhotosGallery = photosGalleryService.getAllPhotosGallery();
		m.addAttribute("listPhotosGallery", listPhotosGallery);
		return "user/suggestion";
	}

	@PostMapping("/suggestion")
	public String saveSuggestion(Suggestion suggestion) {

		User user = userService.loadUserById(1);
		suggestion.setUser(user);
		suggestion.setLikeCount(0);
		suggestion.setEntryDate(new Date());
		suggestion.setDislikeCount(0);
		suggestionService.createOrUpdateSuggestion(suggestion);
		return "redirect:/";
	}

	@GetMapping("/gallery")
	public String showGallery(Model m) {
		List<PhotosGallery> listPhotosGallery2 = photosGalleryService.getAllPhotosGallery();
		m.addAttribute("listPhotosGallery2", listPhotosGallery2);

		List<PhotosGallery> listPhotosGallery = photosGalleryService.getAllPhotosGallery();
		m.addAttribute("listPhotosGallery", listPhotosGallery);
		return "user/gallery";
	}

	@GetMapping("/forthcomingevent")
	public String showForthcomingEvent(Model m) {

		List<Event> listEvent = eventService.findAllByStartDate(new Date());
		m.addAttribute("listEvent", listEvent);

		List<PhotosGallery> listPhotosGallery = photosGalleryService.getAllPhotosGallery();
		m.addAttribute("listPhotosGallery", listPhotosGallery);

		return "user/forth-coming-event";

	}

	@GetMapping("/uploadpost")
	public String showPost(Model m, Post post) {

		List<PhotosGallery> listPhotosGallery = photosGalleryService.getAllPhotosGallery();
		m.addAttribute("listPhotosGallery", listPhotosGallery);
		return "user/uploadpost";
	}

	@PostMapping("/uploadpost")
	public String savePost(Post post, @RequestParam("file") MultipartFile file) throws IOException {
		User user = userService.loadUserById(1);
		post.setUser(user);
		post.setLikeCount(0);
		post.setEntryDate(new Date());
		post.setStatus("Inactive");
		post.setDislikeCount(0);
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.length() > 3) {
			post.setPhoto(fileName);
			postService.createOrUpdatePost(post);
			String uploadDir = "assets1/images/posts";
			FileUploadUtil.saveFile(uploadDir, fileName, file);
		} else {
			postService.createOrUpdatePost(post);
		}
		return "redirect:/";
	}

	@GetMapping("/feedback")
	public String showFeedback(Model m, Feedback feedback) {
		List<Feedback> listFeedback = feedbackService.getAllFeedback();
		m.addAttribute("listFeedback", listFeedback);

		List<PhotosGallery> listPhotosGallery = photosGalleryService.getAllPhotosGallery();
		m.addAttribute("listPhotosGallery", listPhotosGallery);
		return "user/feedback";
	}

	@PostMapping("/feedback")
	public String saveFeedback(Feedback feedback) {

		feedbackService.createOrUpdateFeedback(feedback);

		return "redirect:/";
	}

	@GetMapping("/event")
	public String showEvent(Model m, Event event) {
		List<Event> listEvent = eventService.findAllByLastDate(new Date());
		m.addAttribute("listEvent", listEvent);

		List<PhotosGallery> listPhotosGallery = photosGalleryService.getAllPhotosGallery();
		m.addAttribute("listPhotosGallery", listPhotosGallery);
		return "user/event";

	}

	@GetMapping("/event-detail/{id}")
	public String showEventDetail(Model m,@PathVariable("id")int id) {
		Event event = eventService.loadEventById(id);
		m.addAttribute("event", event);

		List<PhotosGallery> listPhotosGallery = photosGalleryService.getAllPhotosGallery();
		m.addAttribute("listPhotosGallery", listPhotosGallery);
		return "user/event-detail";

	}
	
	@GetMapping("/event-registration/{id}")
	public String showEventRegistration(@PathVariable("id") int id, Model m, HttpSession session) {
		if(Helper.checkStudentRole()==false && Helper.checkTempUserRole()==false)
			return "redirect:/login";
		
		Event event = eventService.loadEventById(id);
			
		
		EventRegistration eventRegistration = new EventRegistration();
		eventRegistration.setEvent(event);
		
		String urole = session.getAttribute("urole").toString();
		int uid = (int)session.getAttribute("uid");
		if(urole.equalsIgnoreCase("student") || urole.equalsIgnoreCase("temp-student"))
		{
			User user = userService.loadUserById(uid); 
			eventRegistration.setUser(user);
			
		}else {
			session.setAttribute("msg", "only Student and Temp-Student can regiter an Event");
			return "redirect:/login";
		}
		
		m.addAttribute("eventRegistration",eventRegistration);
		
		List<PhotosGallery> listPhotosGallery = photosGalleryService.getAllPhotosGallery();
		m.addAttribute("listPhotosGallery", listPhotosGallery);
		
		return "user/event-registration";

	}

	@PostMapping("/event-registration")
	public String saveEventRegistration(EventRegistration eventRegistration, HttpSession session) {
        int uid = (int)session.getAttribute("uid");
        User user = userService.loadUserById(uid);
        
		eventRegistration.setUser(user);
		eventRegistration.setPaymentType("CASH");
		eventRegistration.setPaymentDetail("PAID AT OFFICE");
		
		eventRegistrationService.createOrUpdateEventRegistration(eventRegistration);
        session.setAttribute("msg", "Registration Completed Successfully..");
		
        return "redirect:/forthcomingevent";
	}

	@GetMapping("/myprofile")
	public String showProfile(Model m) {

		return "user/myprofile";
	}

	@GetMapping("/post")
	public String showPost(Model m) {
		
		List<Post> listPost = postService.getAllPost();
		m.addAttribute("listPost", listPost);

		List<PhotosGallery> listPhotosGallery = photosGalleryService.getAllPhotosGallery();
		m.addAttribute("listPhotosGallery", listPhotosGallery);
		return "user/post";

	}

}
