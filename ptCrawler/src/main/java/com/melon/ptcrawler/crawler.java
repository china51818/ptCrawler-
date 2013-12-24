/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.melon.ptcrawler;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author 彭涛
 */
public class crawler {

    public static void main(String[] args) throws Exception {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://www.oschina.net");

        HttpResponse response1 = httpclient.execute(httpGet);

        try {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(entity1.getContent(), "UTF-8"));
            Document doc = Jsoup.parse(entity1.getContent(), "UTF-8", "http://www.oschina.net");

//            Element content = doc.getElementsByTag("body").get(0);
            Elements links = doc.getElementsByTag("a");
            for (Element link : links) {
                String linkHref = link.attr("href");
                String linkText = link.text();
                System.out.println(linkText+"::"+linkHref);
                System.out.println();
            }
            EntityUtils.consume(entity1);
        }
        finally {
            httpGet.releaseConnection();
        }
    }
}
