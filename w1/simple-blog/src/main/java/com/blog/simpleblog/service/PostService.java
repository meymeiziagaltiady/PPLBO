package com.blog.simpleblog.service;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.blog.simpleblog.repository.PostJpaRepository;
import com.blog.simpleblog.repository.PostRepository;
import com.blog.simpleblog.vo.Post;

@Service
public class PostService {
    // private static List<Post> posts;

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostJpaRepository jpaRepository;

    public Post getPost(Long id){
        Post post = jpaRepository.findOneById(id);
    
        return post;
    }

    public List<Post> getPosts(){
        List<Post> posts = jpaRepository.findAllByOrderByUpdtDateDesc();

        return posts;
    }

    public List<Post> getPostsOrderByUpdtAsc(){
        List<Post> postList = jpaRepository.findAllByOrderByUpdtDateAsc();

        return postList;
    }

    public List<Post> searchPostByTitle(String query){
        List<Post> posts = jpaRepository.findByTitleContainingOrderByUpdtDateDesc(query);
    
        return posts;
    }

    public List<Post> searchPostByContent(String query){
        List<Post> posts = jpaRepository.findByContentContainingOrderByUpdtDateDesc(query);

        return posts;
    }

    public boolean savePost(Post post){
        Post result = jpaRepository.save(post);
        boolean isSuccess = true;

        if (result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public boolean deletePost(Long id){
        Post result = jpaRepository.findOneById(id);

        if (result == null) {
            return false;
        }

        jpaRepository.deleteById(id);
        return true;
    }

    public boolean updatePost(Post post){
        Post result = jpaRepository.findOneById(post.getId());

        if (result == null) {
            return false;
        }

        if (!StringUtils.isEmpty(post.getTitle())) {
            result.setTitle(post.getTitle());
        }

        if (!StringUtils.isEmpty(post.getContent())) {
            result.setContent(post.getContent());
        }

        jpaRepository.save(result);
        return true;
    }

    // sebelum JPA
    // public Post getPost(Long id){
    //     Post post = postRepository.findOne(id);

    //     return post;
    // }

    // public List<Post> getPosts(){
    //     List<Post> postList = postRepository.findPost();

    //     return postList;
    // }

    // public List<Post> getPostsOrderByUpdtAsc(){
    //     List<Post> postList = postRepository.findPostOrderByUpdtDateAsc();

    //     return postList;
    // }

    public List<Post> getPostsOrderByRegDesc(){
        List<Post> postList = postRepository.findPostOrderByRegDateDesc();

        return postList;
    }
    
    // sebelum jpa
    // public List<Post> searchPostByTitle(String query){
    //     List<Post> posts = postRepository.findPostLikeTitle(query);

    //     return posts;
    // }
    // public List<Post> searchPostByContent(String query){
    //     List<Post> posts = postRepository.findPostLikeContent(query);

    //     return posts;
    // }
    // public boolean savePost(Post post){
    //     int result = postRepository.savePost(post);
    //     boolean isSuccess = true;

    //     if (result == 0) {
    //         isSuccess = false;
    //     }

    //     return isSuccess;
    // }

    // sebelum pakai mysql
    // public Post getPost(int id){
    //     // Post post = new Post(1L, "Mike", "Mike's Post", "Welcome to My blog");
    //     Post post = posts.get(id-1);

    //     return post;
    // }

    // public List<Post> getPosts(){
	// 	posts = new ArrayList<>();

	// 	posts.add(new Post(1L, "Mike", "Mike's Post", "Welcome to My blog"));
	// 	posts.add(new Post(2L, "Jason", "It's Jason", "Hi, My name is Jason"));

	// 	return posts;
	// }
}
