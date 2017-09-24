package cblog.core.data;

import java.util.Date;

/**
 * Created by chenchicheng on 17-9-19.
 */
public class User {
    private long id;
    private String username;//用户名
    private String password;//密码
    private String avatar;  //头像
    private String email;   //邮箱
    private String mobile;  //联系方式

    private String  posts;   //文章数
    private Integer comments;//发布评论数
    private Integer follows; //关注人数
    private Integer fans;    //粉丝数
    private Integer favors;  //文章被收藏数

    private Date created;    //创建时间
    private String signature;//个性签名

    private Integer status;  //状态
    private Integer activeEmail;//邮箱是否激活

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getActiveEmail() {
        return activeEmail;
    }

    public void setActiveEmail(Integer activeEmail) {
        this.activeEmail = activeEmail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }

    public Integer getFavors() {
        return favors;
    }

    public void setFavors(Integer favors) {
        this.favors = favors;
    }

    public String getPosts() {
        return posts;
    }

    public void setPosts(String posts) {
        this.posts = posts;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getFollows() {
        return follows;
    }

    public void setFollows(Integer follows) {
        this.follows = follows;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
