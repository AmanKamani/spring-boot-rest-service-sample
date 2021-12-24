package jb.production.restwebservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
    private Integer id;

    @Size(min = 2, message = "Name should have atleast 2 characters")
    private String name;
    @Past(message = "Birthdate should be past dates")
    private Date birthDate;
    private List<Posts> posts = new ArrayList<Posts>();
    private int postCount = 0;

    public User(int id, String name, Date birthdate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthdate;
    }

    public void addDefaultPost() {
        for (int i = 1; i < 3; i++) {
            ++postCount;
            posts.add(new Posts(postCount, "post-" + i, new Date()));
        }
    }

    public Integer getId() {
        return id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void addPosts(List<Posts> posts) {
        for(Posts post: posts){
            post.setPostId(++postCount);
        }
        this.posts.addAll(posts);
    }

    public List<Posts> getPosts() {
        return this.posts;
    }

    public Posts getPosts(int postId){
        for(Posts post: posts){
            if(post.getPostId() == postId)
                return post;
        }
        return null;
    }

    @Override
    public String toString() {
        return "User(" + this.id + "," + this.name + "," + this.birthDate + ")";
    }

}
