package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSecurityController {

	@RequestMapping("/")
	public String Hello() {
		return "Hello World";
	}
	@RequestMapping("/notprotected")
	public String HelloAgain() {
		return "Hello from a non-protected page";
	}
	@RequestMapping("/protectedByUserRole")
	public String HelloUser() {
		return "Hello User Role";
	}
	@RequestMapping("/protectedByAdminRole")
	public String HelloAdmin() {
		return "Hello Admin Role";
	}
  
}
