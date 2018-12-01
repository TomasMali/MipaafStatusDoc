package App;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class Start {

	public static void main(String[] args) {
		ApiContextInitializer.init();

		// Instantiate Telegram Bots API
		TelegramBotsApi botsApi = new TelegramBotsApi();
		System.out.println("Application has been started!");

		// Register our bot
		try {
			botsApi.registerBot(new SianConnect());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

	}

}
