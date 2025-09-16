package com.Allamanos.Fundacao.Repository;

import com.Allamanos.Fundacao.Entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> id(Long id);
}
