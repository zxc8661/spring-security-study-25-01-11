package com.ll.demo.controller;


import com.ll.demo.model.Post;
import com.ll.demo.service.PostService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/list")
    public List<Post> postList(){
      return postService.postList();
    }





}
