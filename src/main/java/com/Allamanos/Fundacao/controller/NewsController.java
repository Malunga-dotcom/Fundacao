package com.Allamanos.Fundacao.controller;

import com.Allamanos.Fundacao.Entity.News;
import com.Allamanos.Fundacao.Service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class NewsController {

        private final NewsService newsService;

        @PostMapping("/news")
        public News postNews(@RequestBody News news)
        {
            return newsService.postNews(news);
        }

        @GetMapping("/news")
        public List<News> RetrieveAllNews(){
            return newsService.getAllNews();
        }

        @GetMapping("/news/{id}")
        public ResponseEntity<News> getNewsById(@PathVariable Long id) {
            News news= newsService.getNewsById(id);
            if(news == null)
                return ResponseEntity.notFound().build();
            return ResponseEntity.ok(news);
        }
        @PutMapping("/news/{id}")
        public ResponseEntity<News> updateNews(@PathVariable Long id, @RequestBody News news)
        {
            News extingNews = newsService.getNewsById(id);
            if(extingNews == null)
                return ResponseEntity.notFound().build();
            extingNews.setTitle(news.getTitle());
            extingNews.setTitle(news.getSubTitle());
            extingNews.setDescription(news.getDescription());
            extingNews.setImageUrl(news.getImageUrl());
            return ResponseEntity.ok(newsService.updateNews(extingNews));
        }

        @DeleteMapping("/news/{id}")
        public ResponseEntity<?> deleteProject( @PathVariable Long id) {
            News existingNewsToDelete = newsService.getNewsById(id);
            if(existingNewsToDelete == null)
                return ResponseEntity.notFound().build();
            newsService.deleteNews(id);
            return ResponseEntity.ok().build();
        }
}
