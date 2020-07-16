package com.pringles.web.article;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "article")
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @Column(length = 20)
    private String title;

    @Column(length = 20)
    private LocalDateTime writeDate;

    @Column(length = 20)
    private String recruit;

    @Column(length = 10)
    private String workDay;

    @Column(length = 20)
    private String workTime;

    @Column(length = 2)
    private String workAge;

    @Column(length = 10)
    private String cityArea;

    @Column(length = 255)
    private String content;

    @Builder
    public Article(String title, LocalDateTime writeDate, String recruit, String workDay, String workTime, String workAge, String cityArea, String content) {
        this.title = title;
        this.writeDate = writeDate;
        this.recruit = recruit;
        this.workAge = workAge;
        this.workDay = workDay;
        this.workTime = workTime;
        this. cityArea = cityArea;
        this.content = content;
    }

}
