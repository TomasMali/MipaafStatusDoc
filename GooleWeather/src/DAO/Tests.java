package DAO;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class Tests {

	public static void main(String[] args) throws IOException {

		String link = "https://www.sian.it/portale-mipaaf/servizio?sid=2166";

		// URL url = new URL(link);
		// HttpURLConnection http = (HttpURLConnection) url.openConnection();
		// int statusCode = http.getResponseCode();
		//
		// System.out.println("My status code is: " + statusCode);

		URL url = new URL(
				"https://www.sian.it/public/mipaaf/Modalita_registro_vitivinicolo_v4%20(S-MIP-MRGA-K3-15002).pdf");

		System.out.println("URL:- " + url);
		URLConnection connection = url.openConnection();

		System.out.println(connection.getHeaderField("Last-Modified"));

		// List<Abilitazione> users = Queries.GetUserIdWithProjectAndDescription("Sian", "SianConnect");
		//
		// Queries.UpdateTimestampLinks(1, new Date(System.currentTimeMillis()).toString());
		//
		// System.out.println(new Date(System.currentTimeMillis()).toString());
		// System.out.println(users);

		// String time = new Date(System.currentTimeMillis()).toString();
		// Queries.InsertUser(new User((long) 99999949, "Test", "Test", time));

		// System.out.println(LocalDateTime.now());

		// System.out.println("La Lista è: " + Queries.getAllLinkDescription());

		// boolean b = Queries.getAbilitazione(new Abilitazione((long) 145645559, (long) 1, false));

		// System.out.println(b);

	}

}
