package com.blog.simpleblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.simpleblog.service.*;
import com.blog.simpleblog.vo.Post;

@RestController
public class PostController {

	@Autowired
	PostService postService;
	
	@GetMapping("/post")
	public Post getPost(@RequestParam("id") int id){
		Post post = postService.getPost(id);
		return post;
	}
	
	@GetMapping("/posts")
	public List<Post> getPosts(){
		List<Post> posts = postService.getPosts();

		return posts;
	}

	@GetMapping("/post/{id}")
	public Post getPostPathParam(@PathVariable("id") int id) {
		Post post = postService.getPost(id);
		return post;
	}
	
}
