package Tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class Tests {

	public static void main(String[] args) throws IOException { // Fri Nov 23 14:34:18 CET 2018
																// Guida-chiusura-campagna_v2 Wed, 02 Aug 2017 13:57:42
																// GMT

		String urlR = "https://www.sian.it/public/mipaaf/vers%204.6.zip";

		URL url_1 = new URL(urlR);
		HttpURLConnection http_1 = (HttpURLConnection) url_1.openConnection();
		int statusCode = http_1.getResponseCode();
		String dataModifica = new Date(url_1.openConnection().getLastModified()).toString();

		System.out.println(dataModifica);

	}

}
