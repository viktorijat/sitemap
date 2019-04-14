package com.example.sitemap.service;

import com.example.sitemap.model.Url;
import com.example.sitemap.model.UrlSet;
import com.redfin.sitemapgenerator.ChangeFreq;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.Set;

@Service
public class Crawler {

    @Autowired
    private UrlService urlService;

    public void getLinks(String url, Set<Url> urls) {


        if (urls.contains(url) || !linkIsAcceptable(url)) {
            return;
        }

        urlService.addUrl(new Url(url, new Date(), ChangeFreq.HOURLY, 1.0));

        urls.add(new Url(url, new Date(), ChangeFreq.HOURLY, 1.0));

        Document doc;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            return;
        }
//        if (doc != null) {
//            Elements elements = doc.select("a");
//            for (Element element : elements) {
//                String link = element.absUrl("href");
//                if (!linkIsAcceptable(link)) {
//                    continue;
//                }
//                getLinks(link, urls);
//            }
//        }
    }

    private boolean linkIsAcceptable(String link) {
        return !link.isEmpty() && !link.equals("/") && link.startsWith("https://www.babylonhealth.com/")
                && !link.endsWith("zip");
    }
}
