package by.itacademy.matveenko.jd2.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class News implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String titleNews = "";
	private String briefNews = "";
	private String contentNews = "";
	private LocalDate date;
	private User user;
	
	public News() {
	}

	public News(String titleNews, String briefNews, String contentNews, LocalDate date, User user) {
		this.titleNews = titleNews;
		this.briefNews = briefNews;
		this.contentNews = contentNews;
		this.date = date;
		this.user = user;
	}
	
	public News(String titleNews, String briefNews, String contentNews, LocalDate date) {		
		this.titleNews = titleNews;
		this.briefNews = briefNews;
		this.contentNews = contentNews;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitleNews() {
		return titleNews;
	}

	public void setTitleNews(String titleNews) {
		this.titleNews = titleNews;
	}

	public String getBriefNews() {
		return briefNews;
	}

	public void setBriefNews(String briefNews) {
		this.briefNews = briefNews;
	}

	public String getContentNews() {
		return contentNews;
	}

	public void setContentNews(String contentNews) {
		this.contentNews = contentNews;
		
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        News that = (News) obj;
        return Objects.equals(id, that.id) && Objects.equals(titleNews, that.titleNews) && Objects.equals(briefNews, that.briefNews) && Objects.equals(contentNews, that.contentNews) 
        		&& Objects.equals(date, that.date) && Objects.equals(user, that.user);
    }
	
	@Override
    public String toString() {
        return "News{" +
                "id='" + id + '\'' +
                ", titleNews='" + titleNews + '\'' +
                ", briefNews='" + briefNews + '\'' +
                ", contentNews='" + contentNews + '\'' +
                ", date='" + date + '\'' + 
                ", user='" + user.toString() + '\'' +
                '}';
    }	
}