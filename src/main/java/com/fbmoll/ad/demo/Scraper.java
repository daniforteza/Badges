package com.fbmoll.ad.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Scraper {
    //URL: https://www.google.com/search?q=
    //Selector: h3.r a
    public static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36";

    public List<SearchResult> searchResults() throws IOException {
        List<SearchResult> resultList = new ArrayList<>();
        final String query = "españa";
        final Document page = Jsoup.connect("https://www.google.com/search?q=" + URLEncoder.encode(query, "UTF-8")).userAgent(USER_AGENT).get();


        for (Element searchResult : page.select("h3.r a")) {

            String title = searchResult.text();
            String url = searchResult.attr("href");

            resultList.add(new SearchResult(title,url));
        }
        return resultList;
    }
}