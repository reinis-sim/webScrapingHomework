import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) throws IOException {
		
		ArrayList<String> saraksts = new ArrayList<String>();
		
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		
		Document doc = Jsoup.connect("https://manabalss.lv/pret-a-caka-ielas-sasaurinasanu-lidz-vienai-joslai-katra-virziena-un-par-velojoslu-atcelsanu/show")
				.timeout(6000).get();
	
		
		Elements div = doc.select("div.votes");
		//System.out.println(div.select("a").size());
		for(Element e : div.select("a"))
		{
			String name  = e.select("a").attr("title");
			//System.out.println(name);
			saraksts.add(name);
		}
		
		System.out.println(saraksts);
		
	
			
		 FileWriter writer = new FileWriter("output.txt", true);
		 writer.write("Update at "+ formatter.format(new Date()) + "\n"+ "\n");
		 for(String str: saraksts) { 
			 writer.write(str + System.lineSeparator());
			 }
		 writer.close();
		 
		 
		 
		 
		

		
		
	}
}
