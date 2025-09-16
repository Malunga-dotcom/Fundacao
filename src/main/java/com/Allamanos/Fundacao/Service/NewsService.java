package com.Allamanos.Fundacao.Service;


import com.Allamanos.Fundacao.Entity.News;
import com.Allamanos.Fundacao.Entity.Project;
import com.Allamanos.Fundacao.Repository.NewsRepository;
import com.Allamanos.Fundacao.Repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final NewsRepository newsRepository;

    public News postNews(News news) {
        return newsRepository.save(news);
    }
    public List<News> getAllNews() {
        return newsRepository.findAll() ;
    }
    public News getNewsById(Long id) {
        return newsRepository.findById(id).orElse(null);
    }
    public News updateNews(News news) {return newsRepository.save(news);}
    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }
}
