package com.fbmoll.ad.demo.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fbmoll.ad.demo.document.SearchResult;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class Scraper {
    //URL: https://www.google.com/search?q=
    //Selector: .yuRUbf a[data-ved][ping]
    //http://localhost:8080/api/searchresult/get

    public static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36";

    public List<SearchResult> searchResults() throws IOException {
        List<SearchResult> resultList = new ArrayList<>();
        final String query = "rusia";
        final Document page = Jsoup.connect("https://www.google.com/search?q=" + URLEncoder.encode(query, "UTF-8")).userAgent(USER_AGENT).get();


        for (Element searchResult : page.select(".yuRUbf a[data-ved][ping]")) {
            String url = searchResult.attr("href");
            String title = searchResult.text();

            resultList.add(new SearchResult(url,title));
        }
        return resultList;

    }

}