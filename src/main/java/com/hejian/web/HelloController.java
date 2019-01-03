package com.hejian.web;


import org.apache.commons.lang3.math.NumberUtils;
import org.assertj.core.util.Lists;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.selector.Html;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

/**
 * @author yunfy
 * @create 2017-12-27 13:04
 **/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/testTime")
    public String testTime() {
        Date date = new DateTime().millisOfDay().withMaximumValue().toDate();
        return "";
    }

    @GetMapping("/testHtml")
    public String testHtml(HttpServletRequest request) throws IOException {
        HttpClientDownloader downloader = new HttpClientDownloader();
        Cookie comCookie = WebUtils.getCookie(request, "com");
        Page page = downloader.download(new Request("http://hr.sztest.job5156.com/resume/view/export/1111121825"),
                Site.me().addCookie("hr.sztest.job5156.com", comCookie.getName(), comCookie.getValue()).setCharset("utf-8").toTask());
        Html html = page.getHtml();
        String s = html.get();

        return s;
    }


    public static void main(String[] args) {
        DateTime endDate = DateTime.now().minusDays(1).secondOfDay().withMaximumValue();
        DateTime startDate = endDate.minusMonths(2);
        System.out.println(endDate.toString("yyyy-MM-dd hh:ss:mm"));
        System.out.println(startDate.toString("yyyy-MM-dd"));
        System.out.println( DateTime.now().toString("yyyy-MM-dd"));
        List<Integer> refreshNum = Lists.newArrayList(1, 2, 3, 5);
        int sum = refreshNum.stream().mapToInt(num -> num).sum();
        System.out.println(sum);
    }


    public static boolean compareObject(Object object, double compareNum) {
        String numStr = String.valueOf(object);
        Double doubleNum = NumberUtils.toDouble(numStr, 0);
        if (doubleNum <= 0) {
            return false;
        } else {
            return true;
        }
    }

}
