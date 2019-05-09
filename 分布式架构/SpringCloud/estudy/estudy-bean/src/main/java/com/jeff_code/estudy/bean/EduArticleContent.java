package com.jeff_code.estudy.bean;

public class EduArticleContent {
    private Integer articleId;

    private String content;

    public EduArticleContent(Integer articleId, String content) {
        this.articleId = articleId;
        this.content = content;
    }

    public EduArticleContent() {
        super();
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}