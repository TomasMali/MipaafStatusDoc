package App;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import CallMatches.CallMatches;
import DAO.Queries;

public class SianConnect extends TelegramLongPollingBot {

	public boolean partito = false;

	@Override
	public String getBotToken() {
		return "676793933:AAFSqroVLFsRsYU1nk12-gmVWrYprDN2q-I";
	}

	public String getBotUsername() {
		return "Test2TomasBot";
		// tomasmalibot
		// 502596920:AAGXj1omTxPldCElns1Wiw965LqslMSKBHw
		// TomasSubitoBot
		// 657809545:AAEA4xHiTKLndDuRJc9G5XYrwt-ul2WFqH0
		// tomasweather
		// 601333146:AAHJ4Fa1wDt5x5Tsm2bB7CQE1qhYAEXxyBM
		// siandocstatus
		// 645382473:AAG1Vtkoky27VLINnIWRvaxQxqig-xsbKa4

	}

	@Override
	public void onUpdateReceived(Update update) {

		if (update.hasMessage())
			hasMessage(update);
		else if (update.hasCallbackQuery())
			HasCallbackQuery(update);

	}

	/**
	 * Controlla tutti i messaggi con testo che arrivano e fa il parsing
	 * 
	 * @param update
	 */
	public void hasMessage(Update update) {

		if (update.getMessage().hasText()) {
			if (Queries.userIdExsist(update.getMessage().getChatId()) || update.getMessage().getText().toUpperCase()
					.equals("/REGISTRAMI")) {
				switch (update.getMessage().getText().toUpperCase()) {
				case "SIAN":
					CallMatches.RegoleTechnicheWebServices(this, update);
					break;

				case "/REGISTRAMI":
					CallMatches.UserRegistration(this, update);
					break;
				case "/START":
					CallMatches.createInlineKeyboardLinks(this, update);
					break;
				case "Mipaaf Tecniche Web Service":
					CallMatches.createAbilitazione(this, update, Queries.getLinkId("Mipaaf Tecniche Web Service"));

				default:
					CallMatches.AllOtherMessages(this, update);
					break;
				}
			} else {
				try {
					execute(new SendMessage().setChatId(update.getMessage().getChatId()).setText(
							"Registratiti clickando '/Registrami' prima di usare il bot!"));
				} catch (TelegramApiException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public void HasCallbackQuery(Update update) {
		CallMatches.createAbilitazione(this, update, Queries.getLinkId(update.getCallbackQuery().getData()));
	}

}
