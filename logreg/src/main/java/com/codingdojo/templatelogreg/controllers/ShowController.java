package com.codingdojo.templatelogreg.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.templatelogreg.models.Show;
import com.codingdojo.templatelogreg.models.User;
import com.codingdojo.templatelogreg.services.ShowService;
import com.codingdojo.templatelogreg.services.UserService;



@Controller
@RequestMapping("/shows")
public class ShowController {
    private final ShowService showService;
    private final UserService userService;
    
    public ShowController(ShowService showService, UserService userService) {
        this.showService = showService;
        this.userService = userService;
    }
    
    @GetMapping("/add") 
    public String addRoute(@ModelAttribute("show") Show show) {
    	return "add";
    }
    
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("show") Show show, BindingResult result, Model model, HttpSession session) {
    	Show exists = showService.findTitle(show.getTitle());
    	if(result.hasErrors())  return "add";
    	if(exists != null) {
    		model.addAttribute("showError", "This title already exists");
    		return "add";
    	} else {
    		showService.createShow(show);
    		return "redirect:/users/dashboard";
    	}
    		
    		
}
    @GetMapping("/{show_id}")
    public String displayShow(@PathVariable("show_id") Long show_id, @ModelAttribute("rating") Show show, Model model) {
    	Show singleShow = showService.findShow(show_id);
    	model.addAttribute("singleShow", singleShow );
    	User user = userService.findById(user_id);
	model.addAttribute("users", singleShow.getUsers());
	
    	return "show";
    }
    
//    Book book = bs.findById(id);
//    Author author = as.findById(authorid);
//    List<Author> authors = book.getAuthors();
//    authors.add(Author);
//    bs.update(book);
    
    @PostMapping("/rate/{user_id}/{show_id}")
    public String createRate(@PathVariable("user_id") Long user_id, @PathVariable("show_id") Long show_id, @ModelAttribute("rating") Show rating, Model model) {
    	Show show = showService.findShow(show_id);
    	User user = userService.findById(user_id);
    	List<User> users = show.getUsers();
    	users.add(user);
    	show.setUsers(users);
    	return "show";
    }
    
    
    
    
}
    