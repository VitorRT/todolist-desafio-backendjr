package br.com.vitorbarberino.desafiotodolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DesafioTodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioTodolistApplication.class, args);
	}

	@RestController
	@RequestMapping("/")
	public class HelloController {
		@GetMapping
		public String helloWorld() {
			return "<h1>Hello Vaga Java Backend Jr 👋</h1>";
		}
	}
}
