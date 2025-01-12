package com.ll.demo;

import com.ll.demo.model.Post;
//import com.ll.demo.model.SiteUser;
import com.ll.demo.model.SiteUser;
import com.ll.demo.repository.PostRepository;
//import com.ll.demo.repository.UserRepository;
import com.ll.demo.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication implements CommandLineRunner {

	private final PostRepository postRepository;
	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;
	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		postRepository.deleteAll();
		List<Post> postList = List.of(
				new Post(null,"title1","content1","", LocalDateTime.now()),
				new Post(null,"title2","content2","", LocalDateTime.now()),
				new Post(null,"title3","content3","", LocalDateTime.now())
		);

		postRepository.saveAll(postList);

		List<SiteUser> userList =List.of(
				SiteUser.builder().email("user@user.com")
						.password(passwordEncoder.encode("1234"))
						.name("user")
						.build()
		);


		postRepository.saveAll(postList);
		if (!userRepository.existsByEmail("user@user.com")) {
			userRepository.saveAll(userList);
		}


	}
}
