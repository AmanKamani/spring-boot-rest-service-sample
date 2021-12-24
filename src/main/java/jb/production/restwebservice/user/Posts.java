package jb.production.restwebservice.user;

import java.util.Date;

public class Posts {
    private int postId;
    private String post;
    private Date datePosted;

    public Posts(int id, String post, Date datePosted){
        this.postId = id;
        this.post = post;
        this.datePosted = datePosted;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }
    public int getPostId() {
        return postId;
    }
    public void setPostId(int postId) {
        this.postId = postId;
    }

    
}
