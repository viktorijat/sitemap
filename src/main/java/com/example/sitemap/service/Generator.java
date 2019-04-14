package com.example.sitemap.service;


import com.example.sitemap.model.Url;
import com.example.sitemap.model.UrlSet;
import com.example.sitemap.repository.UrlRepository;
import com.redfin.sitemapgenerator.ChangeFreq;
import com.redfin.sitemapgenerator.WebSitemapGenerator;
import com.redfin.sitemapgenerator.WebSitemapUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class Generator {

    @Autowired
    private static Crawler crawler;

    @Autowired
    private UrlRepository urlRepository;

    public Generator(Crawler crawler) {
        Generator.crawler = crawler;
    }

    public UrlSet generateSiteMap() throws MalformedURLException {
        System.out.println("123");

        UrlSet urlSet = new UrlSet();

        Set<Url> links = new HashSet<>();
        crawler.getLinks("https://www.babylonhealth.com/", links);
        System.out.println(links);

        for (Url url : links) {
            urlSet.addUrl(url);
            System.out.println(url.toString());
        }

        //urlSet.setUrlset(urlRepository.findAll().);

        for (Url u : urlSet.getUrlset()) {
            System.out.println("U: " + u);
        }


//        WebSitemapGenerator sitemapGenerator = WebSitemapGenerator
//                .builder("https://www.babylonhealth.com/", new File("."))
//                .gzip(false).build();


//        for (Url link : links) {
//            System.out.println("link " + link);
//            urlSet.addUrl(new Url(link, new Date(), ChangeFreq.HOURLY, 1.0));
//
////            WebSitemapUrl sitemapUrl = new WebSitemapUrl.Options(link)
////                    .lastMod(new Date()).priority(1.0)
////                    .changeFreq(ChangeFreq.HOURLY).build();
////            sitemapGenerator.addUrl(sitemapUrl);
//        }
        //sitemapGenerator.write();

        return urlSet;
    }
}
