package net.developia.sec;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@Log4j
@RequestMapping("/anno")
@RestController
public class SampleAnnoController {

	@GetMapping(value = "/all", produces = MediaType.TEXT_PLAIN_VALUE)
	public String doAll() {
		log.info("do all can access everybody");
		return "do all can access everybody";
	}
	

	@PreAuthorize(value = "hasAnyRole('ROLE_ADMIN','ROLE_MEMBER','ROLE_MANAGER')")
	@GetMapping(value ="/member", produces = MediaType.TEXT_PLAIN_VALUE)
	public String doMember() {
		log.info("logined member");
		return "logined member";
	}//end doMember
	
	@PreAuthorize(value = "hasRole('ROLE_ADMIN')")
	@GetMapping(value ="/admin", produces = MediaType.TEXT_PLAIN_VALUE)
	public String doAdmin() {
		log.info("admin only");
		return "admin only";
	}//end doAdmin	
}