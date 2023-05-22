package com.campusdiaries.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;



public class Helper {
	
	
//	public Category getCategoryList(Category category){
//		
//		List<Product> product_list = new ArrayList<>();
//		
//		for (Iterator iterator2 = category.getProducts().iterator(); iterator2.hasNext();) {
//			Product p = (Product) iterator2.next();
//			product_list.add(p);
//		System.out.println(p.toString());
//		}
//		
//		if(product_list.size() >=10)
//		{	product_list= product_list.subList(0, 10);}
//		
//		Set<Product> product_set = new HashSet<>();
//		product_set.addAll(product_list);
//		category.setProducts(product_set);
//		
//		
//				
//		return category;
//		 
//	}
	
	public static boolean checkAdminRole() {
		String role="";
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();
		
		if(session.getAttribute("urole") != null) {
			role = session.getAttribute("urole").toString();
		}
		return role.equalsIgnoreCase("ADMIN");
	}
	public static boolean checkUserRole() {
		String role="";
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();
		
		if(session.getAttribute("urole") != null) {
			role = session.getAttribute("urole").toString();
		}
		return role.equalsIgnoreCase("CUSTOMER");
	}
	public static String getOrderNo(int id) {
		String pattern = "yyyyMMdd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		
		String ids = String.valueOf(10000+id);
			
		return date+"-"+ids;
		
	}
	public static boolean checkStaffRole() {
		String role="";
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();
		
		if(session.getAttribute("urole") != null) {
			role = session.getAttribute("urole").toString();
		}
		return role.equalsIgnoreCase("staff");
	}
	public static boolean checkStudentRole() {
		String role="";
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();
		
		if(session.getAttribute("urole") != null) {
			role = session.getAttribute("urole").toString();
		}
		return role.equalsIgnoreCase("student");
	
	}
	public static boolean checkTempUserRole() {
		String role="";
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();
		
		if(session.getAttribute("urole") != null) {
			role = session.getAttribute("urole").toString();
		}
		return role.equalsIgnoreCase("Temp-Student");//from Database
	
	}
	
	public static boolean checkSession() {
		int uid=0;
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();
		
		if(session.getAttribute("uid") != null) {
			uid = (int)session.getAttribute("uid");
		}
		return uid>0;
	}

}
