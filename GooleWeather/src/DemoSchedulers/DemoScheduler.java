package DemoSchedulers;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import App.SianConnect;
import DAO.Abilitazione;
import DAO.Queries;
import Jsoup.Query;

/**
 * This is a sample class to execute scheduler on specific date based on <code>java.util.Calendar</code>. Over here,
 * <code>executor</code> is a runnable which run on everyday basis from 8:00 AM to 5:00 PM.
 * 
 * @author Tomas Mali
 */
public class DemoScheduler {

	public static SianConnect mySianConnect = null;
	public static Update update = null;
	public static String query = "";
	public static boolean firstTime = true;
	public static ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	public static Long mio = (long) 145645559;

	public DemoScheduler(SianConnect instance, Update update) {
		mySianConnect = instance;
		this.update = update;

	}

	public static void setQuery(String s) {
		query = s;
	}

	/**
	 * Questo metodo fa partire il thread
	 * 
	 * @throws IOException
	 */
	public static void runThreadWithTask() throws IOException {

		Runnable task = new Runnable() {

			@Override
			public void run() {

				String query = Query.copyURLToFile("https://www.sian.it/public/mipaaf/WS%20MVV-E%20vers%201.7.zip");
				System.out.println("La query è : " + query);

				List<Abilitazione> listAbilitations = Queries.GetUserIdWithProjectAndDescription("Sian",
						"Mipaaf Tecniche Web Service");

				// Nel caso ci siano aggiornamenti
				if (query.equals("Attenzione ci sono aggiornamenti dal sito di MIPAAF")) {

					try {
						for (Abilitazione ab : listAbilitations) {
							SendMessage message = new SendMessage().setChatId(ab.getUserid()).setText(query + "\n"
									+ " Ultima modifica rilevata : " + new java.util.Date().toGMTString());
							mySianConnect.execute(message);
						}
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
					// ** qui si potrebbe aggiornare il timestamp del sito ed evitare di ristartare l'applicazione
					scheduler.shutdown();
				} else if (query.equals("Non ci sono Aggiornamenti dal sito di MIPAAF")) {
					// è la prima volta
					Abilitazione abilitazione = Queries.getSingleAbilitazione(update.getMessage().getChatId());
					boolean NonprimaVolta = Queries.getAbilitazioneStartedValue(abilitazione);
					if (!NonprimaVolta) {
						SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId()).setText(
								query);
						try {
							Queries.threadStartedTrue(abilitazione.getUserid(), abilitazione.getLink());
							mySianConnect.execute(message);

						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					}
					// notifica solo me per il sistema down
				} else if (query.equals("404")) {
					SendMessage message = new SendMessage().setChatId(mio).setText(
							"Il sito MIPAAF è andato giù con codice : " + query);
					try {
						mySianConnect.execute(message);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				}

			}
		};

		// scheduler.schedule(task, 1, TimeUnit.MINUTES);
		scheduler.scheduleWithFixedDelay(task, 0, 20, TimeUnit.MINUTES);

	}
}