package com.stackroute.newz.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.newz.model.News;

/*
 * This class is implementing the NewsDAO interface. This class has to be annotated with @Repository
 * annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, thus 
 * 				 clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database 
 * 					transaction. The database transaction happens inside the scope of a persistence 
 * 					context.  
 * */
@Repository
@Transactional("txManager")
public class NewsDAOImpl extends AbstractDao implements NewsDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.
	 */
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public NewsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/*
	 * Save the news in the database(news) table.
	 */
	public boolean addNews(News news) {
		save(news);
		return true;
	}

	/*
	 * retrieve all existing news sorted by created Date in descending
	 * order(showing latest news first)
	 */
	public List<News> getAllNews() {
		return getSession().createQuery("from News", News.class).getResultList();
	}

	/*
	 * retrieve specific news from the database(news) table
	 */
	public News getNewsById(int newsId) {
		News news = getSession().get(News.class, newsId);
		System.out.println("NewsById: "+news);
		return news;
	}

	public boolean updateNews(News news) {
		News newss = getSession().get(News.class, news.getNewsId());
		System.out.println("NewsById: "+newss);
		getSession().update(news);
		return true;
	}

	/*
	 * Remove the news from the database(news) table.
	 */
	public boolean deleteNews(int newsId) {
		News news = getNewsById(newsId);
		if(news == null) {
			return false;
		}

		getSession().delete(news);
		return true;
	}
	
}