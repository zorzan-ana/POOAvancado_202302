package br.edu.atitus.exemploinicial;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorld {
	
	@GetMapping("status")
	public String getStatus() {
		return "Hello World!!!";
	}
	
	
	@PostMapping("exemplopost")
	public String postTeste() {
		return "Teste Post";
	}

}
