package project.simsim.systems.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManageMemController 
{
	@RequestMapping("manageMem/{temp}.do")
	public String test(@PathVariable String temp)
	{
		return "/manageMem/"+temp;
	}
}
