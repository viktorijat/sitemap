package com.example.sitemap.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UrlSet {

    @OneToMany
    private Set<Url> urlset;

    public Set<Url> getUrlset() {
        return urlset;
    }

    public void setUrlset(Set<Url> urlset) {
        this.urlset = urlset;
    }

    public void addUrl(Url url) {
        Set<Url> urls = this.getUrlset();
        if (urls == null) {
            urls = new HashSet<>();
        }
        urls.add(url);
        this.setUrlset(urls);
    }
}
