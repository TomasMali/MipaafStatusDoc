package Tests;

import java.io.IOException;

import ConnectionDB.Queries;
import DAO.Links;

public class Tests {

	public static void main(String[] args) throws IOException { // Fri Nov 23 14:34:18 CET 2018

		Links link = new Links(1, "Mipaaf Tecniche Web Service",
				"https://www.sian.it/public/mipaaf/WS%20MVV-E%20vers%201.7.zip", "Fri Nov 23 14:34:18 CET 2018",
				"Sian");
		Queries.updateLinkTimestamp(link);

		System.out.println("Ok");

	}

}
