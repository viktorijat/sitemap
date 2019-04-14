package com.example.sitemap;

import com.example.sitemap.service.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SiteMapApplication {

//	private static Crawler crawler;
//	private static Generator generator;

//	@Autowired
//    public SiteMapApplication(Crawler crawler) {
//        SiteMapApplication.crawler = crawler;
//    }

//    @Autowired
//    public SiteMapApplication(Generator generator) {
//        SiteMapApplication.generator = generator;
//    }

	public static void main(String[] args) throws MalformedURLException {
		SpringApplication.run(SiteMapApplication.class, args);
		//Set<String> links = new HashSet<>();
//		crawler.getLinks("https://www.babylonhealth.com/", links);
//		for (String link : links) {
//			System.out.println("link: " + link);
//		}

        //generator.generateSiteMap();
	}

}
