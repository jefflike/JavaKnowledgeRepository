package com.jeff_code.estudy.bean;

import java.util.Date;

public class EduArticle {
    private Integer articleId;

    private String title;

    private String summary;

    private String keyWord;

    private String imageUrl;

    private String source;

    private String author;

    private Date createTime;

    private Date publishTime;

    private String link;

    private Byte articleType;

    private Integer clickNum;

    private Integer praiseCount;

    private Integer commentNum;

    private Integer sort;

    public EduArticle(Integer articleId, String title, String summary, String keyWord, String imageUrl, String source, String author, Date createTime, Date publishTime, String link, Byte articleType, Integer clickNum, Integer praiseCount, Integer commentNum, Integer sort) {
        this.articleId = articleId;
        this.title = title;
        this.summary = summary;
        this.keyWord = keyWord;
        this.imageUrl = imageUrl;
        this.source = source;
        this.author = author;
        this.createTime = createTime;
        this.publishTime = publishTime;
        this.link = link;
        this.articleType = articleType;
        this.clickNum = clickNum;
        this.praiseCount = praiseCount;
        this.commentNum = commentNum;
        this.sort = sort;
    }

    public EduArticle() {
        super();
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord == null ? null : keyWord.trim();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public Byte getArticleType() {
        return articleType;
    }

    public void setArticleType(Byte articleType) {
        this.articleType = articleType;
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    public Integer getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(Integer praiseCount) {
        this.praiseCount = praiseCount;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}