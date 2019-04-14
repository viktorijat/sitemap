package com.example.sitemap.model;

import com.redfin.sitemapgenerator.ChangeFreq;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Url {

    private String loc;
    private Date lastmod;
    private ChangeFreq changefreq;
    private double priority;

    public Url(String loc, Date lastmod, ChangeFreq changefreq, double priority) {
        this.loc = loc;
        this.lastmod = lastmod;
        this.changefreq = changefreq;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Url{" +
                "loc='" + loc + '\'' +
                ", lastmod=" + lastmod +
                ", changefreq=" + changefreq +
                ", priority=" + priority +
                '}';
    }
}
