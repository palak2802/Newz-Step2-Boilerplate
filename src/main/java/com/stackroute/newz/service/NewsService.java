package com.stackroute.newz.service;

import java.util.List;

import com.stackroute.newz.model.News;

public interface NewsService {
	public boolean addNews(News news);

	public boolean deleteNews(int newsId);

	public List<News> getAllNews();

	public News getNewsById(int newsId);

	public boolean updateNews(News news);


}
