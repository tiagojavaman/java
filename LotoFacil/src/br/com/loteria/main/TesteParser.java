package br.com.loteria.main;

import java.io.File;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TesteParser {

	public static void main(String[] args) {
		try {
			File input = new File("/tmp/D_LOTFAC.HTM");
			Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");

			//Elements linhass = doc.getElementsByTag("tr");
			//for (Element linha : linhass) {
				//String linkHref = linha.attr("td");
				//String linkText = linha.text();
				// System.out.println(linkText);
			//}

			for (Element tabela : doc.select("table")) {
				for (Element linhas : tabela.select("tr")) {
					Elements colunas = linhas.select("td");
					//if (colunas.size() > 6) {
						// System.out.println(colunas.get(0).text() + ":"+ colunas.get(1).text());
					//}
					String str = "";
					for (Integer i = 0; i < colunas.size(); i++) {
						str = str + colunas.get(i).text() + ":";
					}
					System.out.println(str);
				}
			}

		} catch (Exception e) {
			
		}

	}

}
