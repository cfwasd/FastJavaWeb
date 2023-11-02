package com.example.factory.dao.entry;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class News implements Serializable {
    private Long id;
    private String title;
    private String context;
    private String imgUrl;
    private Integer viewCount;
    private Boolean isRecommend;
    private Date inputDate;
    private Long type_id;
    private Long user_id;
    private String imgSmallUrl;
    private NewsType newsType;
    private User user;
    @Override
    public String toString() {
        return "News[" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", viewCount=" + viewCount +
                ", isRecommend=" + isRecommend +
                ", inputDate=" + inputDate +
                ", type_id=" + type_id +
                ", user_id=" + user_id +
                ", imgSmallUrl='" + imgSmallUrl + '\'' +
                ", newsType=" + newsType +
                ", user=" + user +
                ']'+"\n";
    }
}
