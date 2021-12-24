package jb.production.restwebservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<User>();
    private static int usersCount;

    public UserDaoService(){
        System.out.println("instance created");
    }

    static {
        User user1 = new User(1, "John Smith", new Date());
        User user2 = new User(2, "Adam Smith", new Date());
        User user3 = new User(3, "Sakira", new Date());
        user1.addDefaultPost();
        user2.addDefaultPost();
        user3.addDefaultPost();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        usersCount = users.size();
    }

    public User save(User user) {
        if (user.getId() == 0) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    public List<User> findAll(){
        return users;
    }


    public List<Posts> findAllPostsOfUser(int userId){
        for(User user: users){
            if(user.getId() == userId)
                return user.getPosts();
        }
        return null;
    }

    public Posts findPostOne(int userId, int postId){
        for(User user: users){
            if(user.getId() == userId){
                return user.getPosts(postId);
            }
        }
        return null;
    }

    public List<Posts> savePosts(int userId, List<Posts> posts){
        for(User user: users){
            if(user.getId() == userId){
                user.addPosts(posts);
                return posts;
            }
        }
        return null;
    }

    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
