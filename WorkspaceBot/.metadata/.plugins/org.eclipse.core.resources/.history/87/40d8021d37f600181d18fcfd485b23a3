package Tests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class Tests {

	public static void main(String[] args) throws IOException {

		String usl = "https://www.sian.it/public/mipaaf/Codifiche_registro_vitivinicolo_v7%20(S-MIP-MRGA-K3-15004).pdf";
		String due = "https://www.sian.it/public/mipaaf/WS%20MVV-E%20vers%201.7.zip";

		URL url_1 = new URL(due);
		HttpURLConnection http_1 = (HttpURLConnection) url_1.openConnection();
		int statusCode = http_1.getResponseCode();
		String dataModifica = new Date(url_1.openConnection().getLastModified()).toString();

		System.out.println("");

	}

}
