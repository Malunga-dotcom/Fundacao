package com.Allamanos.Fundacao.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String subTitle;
    private String imageUrl;
    private String description;
}
