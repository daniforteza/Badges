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
    //URL: https://www.google.com/search?q=apple
    //Selector: h3.r a
    public static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36";

    public List<SearchResult> searchResults() throws IOException {
        List<SearchResult> searchResults = new ArrayList<SearchResult>();

        final String query = "apple";
        final Document page = Jsoup.connect("https://www.google.com/search?q=" + URLEncoder.encode(query, "UTF-8")).userAgent(USER_AGENT).get();
        final List<SearchResult> resultList = new ArrayList<>();

        for (Element searchResult : page.select("h3.r a")) {

            final String title = searchResult.text();
            final String url = searchResult.attr("href");

            resultList.add(new SearchResult(title,url));
        }
        return searchResults;
    }
}
