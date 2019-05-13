package com.example.myProject1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class MyProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(MyProject1Application.class, args);
	}

	@RequestMapping("/")
	@ResponseBody
	public String racine() {
		return "<ul>" +
				"    <li>The Docs" +
				"        <ul>" +
				"            <li><a href='http://localhost:8080/doctor/1'>William Hartnell</a></li>" +
				"            <li><a href='http://localhost:8080/doctor/2'>David Tennant</a></li>" +
				"            <li><a href='http://localhost:8080/doctor/3'>Jodie Witthaker</a></li>" +
				"            <li><a href='http://localhost:8080/doctor/4'>William Hartnell</a></li>" +
				"        </ul>" +
				"    </li>" +
				"</ul>";
	}
	@RequestMapping("/doctor/1")
	@ResponseBody
	public String william() {
		return " <a href='https://en.wikipedia.org/wiki/William_Hartnell'>William Hartnell</a>";
	}

	@RequestMapping("/doctor/2")
	@ResponseBody
	public String david() {
		return "<a href='https://en.wikipedia.org/wiki/David_Tennant'>David Tennant</a>";
	}

	@RequestMapping("/doctor/3")
	@ResponseBody
	public String jodie() {
		return "<a href='https://en.wikipedia.org/wiki/Jodie_Whittaker'>Jodie Witthaker</a>";
	}

	@RequestMapping("/doctor/4")
	@ResponseBody
	public String sylvester() {
		return "<a href='https://en.wikipedia.org/wiki/Sylvester_McCoy'> Sylvester McCoy</a> ";
	}

}
