package com.fbmoll.ad.demo.document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class SearchResult {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    public String url;
    public String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SearchResult() {
    }

    public SearchResult(String url, String title) {
        this.url = url;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchResult that = (SearchResult) o;

        if (!Objects.equals(title, that.title)) return false;
        return Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", title=" + title +
                '}';
    }
}