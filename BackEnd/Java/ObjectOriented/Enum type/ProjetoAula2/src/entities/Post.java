package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date moment;
    private String title;
    private String content;
    private Integer likes;
    private List<Comment> comments = new ArrayList<>();

    public Post(){}

    public Post(Date moment, String tile, String content, Integer likes){
        this.moment = moment;
        this.title = tile;
        this.content = content;
        this.likes = likes;
    }

    public Date getMoment(){
        return this.moment;
    }

    public void setMoment(Date moment){
        this.moment = moment;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getContent(){
        return this.content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public Integer getLikes(){
        return this.likes;
    }

    public void setLikes(Integer likes){
        this.likes = likes;
    }

    public List<Comment> getComments(){
        return this.comments;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public void removeCooment(Comment comment){
        comments.remove(comment);
    }

    @Override
    public String toString() {
        String quebraLinha = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        sb.append(title + quebraLinha);
        sb.append(likes);
        sb.append(" Likes - ");
        sb.append(sdf.format(moment) + quebraLinha);
        sb.append(content + quebraLinha);
        sb.append("comments:" + quebraLinha);
        for (Comment c : comments) {
            sb.append(c.getText());
        }
        return sb.toString();

    }

}
