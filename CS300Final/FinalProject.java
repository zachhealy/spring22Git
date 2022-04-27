package CS300Final;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FinalProject {
    public static void main(String[] args) throws IOException {

        final String url = "https://liquipedia.net/valorant/VCT/2022/Stage_1/Masters/Statistics";
        String html = getHTML(url);
        // System.out.println(html);
        ArrayList PlayerNames = getNames(url);

    }

    public static String getHTML(String url) throws IOException {
        final Document document = Jsoup.connect(url).get();
        return document.html();
    }

    public static ArrayList getNames(String site) throws IOException {
        ArrayList<String> nameList = new ArrayList<>();
        URL url = new URL(site);
        Document doc = Jsoup.parse(url, 3000);
        Element table = doc.select("table[class=wikitable wikitable-striped sortable jquery-tablesorter").first();
        Iterator<Element> ite = table.select("td:nth-of-type(1)").iterator();
        int i = 0;
        while (i++ < 5) {
            nameList.add(ite.next().text());
        }
        return nameList;
    }
}
