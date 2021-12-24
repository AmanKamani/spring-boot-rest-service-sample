package jb.production.restwebservice.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostsController {

    @Autowired
    private UserDaoService userService;    

    @GetMapping(path = "/users/{userId}/posts")
    public List<Posts> getPosts(@PathVariable int userId){
        return userService.findAllPostsOfUser(userId);
    }

    @GetMapping(path = "/users/{userId}/posts/{postId}")
    public Posts getPost(@PathVariable int userId, @PathVariable int postId){
        Posts savedPost = userService.findPostOne(userId, postId);
        if(savedPost == null)
            throw new PostNotFoundException("Post id-"+postId);
        return savedPost;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/users/{userId}/posts")
    public List<Posts> savePost(@PathVariable int userId, @RequestBody List<Posts> posts){
        List<Posts> createdPosts = userService.savePosts(userId, posts);
        if(createdPosts == null)
            throw new UserNotFoundException("user id-"+userId);
        // URI location = ServletUriComponentsBuilder.fromCurrentRequest().build(userId);
        return createdPosts;
    }

}
