package melon;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainClass {

	public static void main(String[] args) throws IOException {
		// 멜로 100 차트
		System.out.println("조선왕조실록 키워드 검색");
		System.out.println("검색어 예시: 일식");
		Scanner sc  =  new Scanner(System.in);
		System.out.print("검색어: ");
		String str = sc.next();
		String text = URLEncoder.encode(str, "UTF-8");

		String URL = "https://db.itkc.or.kr/search/list?q=query†" + text + "&secId=JT_AA";  // 한국고전종합DB 사이트
		Document doc = Jsoup.connect(URL).get();
		Elements elem = doc.select("table[class=\"wtable mt10\"]");

		for (Element e : elem.select("tr")) {
			if (e.className().equals("line")) {
				System.out.println(e.text());
//				continue;
			}
		}

	}

}
