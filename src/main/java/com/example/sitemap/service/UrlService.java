package com.example.sitemap.service;

import com.example.sitemap.model.Url;
import com.example.sitemap.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public void addUrl(Url url) {
        urlRepository.save(url);
    }
}
