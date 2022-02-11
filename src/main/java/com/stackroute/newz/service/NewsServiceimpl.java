package com.stackroute.newz.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.newz.dao.NewsDAO;
import com.stackroute.newz.model.News;

@Service
@Transactional
public class NewsServiceimpl implements NewsService{
	
	@Autowired
	private NewsDAO newsDao;

	@Override
	public boolean addNews(News news) {
		newsDao.addNews(news);
		return true;
	}

	@Override
	public boolean deleteNews(int newsId) {
		newsDao.deleteNews(newsId);
		return true;
	}

	@Override
	public List<News> getAllNews() {
		return newsDao.getAllNews();
	}

	@Override
	public News getNewsById(int newsId) {
		return newsDao.getNewsById(newsId);
	}

	@Override
	public boolean updateNews(News news) {
		newsDao.updateNews(news);
		return true;
	}

}
