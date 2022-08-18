package by.itacademy.matveenko.jd2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.itacademy.matveenko.jd2.bean.News;
import by.itacademy.matveenko.jd2.dao.INewsDao;
import by.itacademy.matveenko.jd2.dao.NewsDaoException;
import by.itacademy.matveenko.jd2.dao.connectionpool.ConnectionPool;
import by.itacademy.matveenko.jd2.dao.connectionpool.ConnectionPoolException;

public class NewsDao implements INewsDao {
	private static final Logger log = LogManager.getRootLogger();

	@Override
	public List<News> getLatestList(int pageSize) throws NewsDaoException {
		List<News> newsLatestList = new ArrayList<>();
		int startSize = pageSize;
		String selectNewsLatestList = "SELECT * FROM news ORDER BY dateNews DESC LIMIT " + startSize;	 
	        try (Connection connection = ConnectionPool.getInstance().takeConnection();
	        	PreparedStatement ps = connection.prepareStatement(selectNewsLatestList)) {
	            try (ResultSet rs = ps.executeQuery()) {
	                while (rs.next()) {
	                	Integer idNews = rs.getInt("id");
	    				String titleNews = rs.getString("titleNews");
	    				String briefNews = rs.getString("briefNews");
	    				String contentNews = rs.getString("contentNews");
	    				LocalDate date = LocalDate.parse(rs.getDate("date").toString());
	    				//String date = rs.getString("date");
	    				News latestNews = new News(titleNews, briefNews, contentNews, date);
	    				newsLatestList.add(latestNews);
	    			}	    						
	        }	        
	    } catch (SQLException | ConnectionPoolException e) {
	    	log.error(e);
	    	throw new NewsDaoException(e);
	    	}
	        return newsLatestList;
	 }				

	@Override
	public List<News> getNewsList(Integer pageNumber, Integer pageSize) throws NewsDaoException {
		List<News> newsList = new ArrayList<>();
		int startSize = (pageNumber - 1) * pageSize;
		String selectNewsList = "SELECT * FROM news ORDER BY dateNews DESC LIMIT " + startSize + "," + pageSize;	 
	        try (Connection connection = ConnectionPool.getInstance().takeConnection();
	        	PreparedStatement ps = connection.prepareStatement(selectNewsList)) {
	            try (ResultSet rs = ps.executeQuery()) {
	                while (rs.next()) {
	                	Integer idNews = rs.getInt("id");
	    				String titleNews = rs.getString("titleNews");
	    				String briefNews = rs.getString("briefNews");
	    				String contentNews = rs.getString("contentNews");
	    				LocalDate date = LocalDate.parse(rs.getDate("date").toString());
	    				//String date = rs.getString("date");    				
	    				News news = new News(titleNews, briefNews, contentNews, date);
	    				newsList.add(news);
	    			}	    						
	        }	        
	    } catch (SQLException | ConnectionPoolException e) {
	    	log.error(e);
	    	throw new NewsDaoException(e);
	    	}
	        return newsList;
	 }				
	
	@Override
	public News fetchById(Integer id) throws NewsDaoException {
		News news = null;
		String selectNewsById = "SELECT * FROM news WHERE id = ?";
		try (Connection connection = ConnectionPool.getInstance().takeConnection();
	        PreparedStatement ps = connection.prepareStatement(selectNewsById)) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                	Integer idNews = rs.getInt("id");
                	String titleNews = rs.getString("titleNews");
    				String briefNews = rs.getString("briefNews");
    				String contentNews = rs.getString("contentNews");    				
    				LocalDate date = LocalDate.parse(rs.getDate("date").toString());
    				//String date = rs.getString("date");
    				news = new News(titleNews, briefNews, contentNews, date);
    				}
                }
			} catch (SQLException | ConnectionPoolException e) {
				log.error(e);
				throw new NewsDaoException(e);
			}
			return news;
	}

	@Override
	public int addNews(News news) throws NewsDaoException {
		int row = 0;
		String insertNews = "INSERT INTO news(titleNews, briefNews, contentNews, dateNews, reporter) VALUES (?,?,?,?,?)";
		try (Connection connection = ConnectionPool.getInstance().takeConnection();
		    PreparedStatement ps = connection.prepareStatement(insertNews)) {
			ps.setString(1, news.getTitleNews());
            ps.setString(2, news.getBriefNews());
            ps.setString(3, news.getContentNews());
            ps.setString(4, news.getDate().format(DateTimeFormatter.ofPattern("YYYY-MM-DD")));
            ps.setString(5, news.getUser().getId().toString());
            row = ps.executeUpdate();
            if (row == 0) {
				throw new NewsDaoException("News not saved!");
			}
			//ResultSet generateKey = ps.getGeneratedKeys();
			//if (generateKey.next()) {
				//throw new NewsDaoException("News not saved!");
			//}
			//System.out.println("generateKey.getInt(DatabaseTableColumn.TABLE_NEWS_COLUMN_ID_NEWS)"
					//+ generateKey.getInt(DatabaseTableColumn.TABLE_NEWS_COLUMN_ID_NEWS));
			//return generateKey.getInt("id");
				} catch (SQLException | ConnectionPoolException e) {
					log.error(e);
					throw new NewsDaoException(e);
				}
				return row;
		}
	
	@Override
	public int updateNews(News news) throws NewsDaoException {
		int row = 0;
		// TODO Auto-generated method stub
		return row;
	}

	@Override
	public void deleteNewses(String[] idNewses) throws NewsDaoException {
		// TODO Auto-generated method stub		
	}
	
	private String getDate() {
	    ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.now(), ZoneId.of("GMT+3"));
	    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	    String date = dateTimeFormatter.format(zonedDateTime);	    
	    return date;
	}
}