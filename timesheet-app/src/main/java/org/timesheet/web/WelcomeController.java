package org.timesheet.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.timesheet.web.helpers.EntityGenerator;
 
import javax.annotation.PostConstruct;

import java.text.SimpleDateFormat;
import java.util.Date;
 
@Controller
@RequestMapping("/welcome")
public class WelcomeController {
	Logger logger = LoggerFactory.getLogger(WelcomeController.class);
 
    @Autowired
    private EntityGenerator entityGenerator;
 
    @RequestMapping(method = RequestMethod.GET)
    public String showMenu(Model model) {
    	String today=new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    	logger.info("Today is: " + today);
        model.addAttribute("today", new Date());
        return "index";
    }
 
    @PostConstruct
    public void prepareFakeDomain() {
        entityGenerator.deleteDomain();
        entityGenerator.generateDomain();
    }
     
}