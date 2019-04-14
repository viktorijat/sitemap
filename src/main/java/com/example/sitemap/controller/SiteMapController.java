package com.example.sitemap.controller;

import com.example.sitemap.model.UrlSet;
import com.example.sitemap.service.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;

@RestController
@RequestMapping("/api/v1/sitemap")
public class SiteMapController {

    @Autowired
    private Generator generator;

    @RequestMapping(method = RequestMethod.GET, value = "", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public UrlSet getSitemap(HttpEntity<String> httpEntity) throws MalformedURLException {
        return generator.generateSiteMap();
    }
}
