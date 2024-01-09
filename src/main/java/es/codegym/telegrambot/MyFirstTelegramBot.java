package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "MonaBot_bot";
    public static final String TOKEN = "Borrado por seguridad";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí}
        String messageText = getMessageText().toLowerCase(); // Se obtiene el texto y ajusta a minúsculas

        if(messageText.equals("/start")){ // Se obtiene el texto y luego se compara
            sendTextMessageAsync("¡Hola! Soy _Mona_.");
        }

        if(messageText.contains("hola")){ // Se obtiene el texto y luego se compara
            sendTextMessageAsync("¿Qué tal, cuál es tu nombre?");
        }

        if(messageText.contains("nombre") || messageText.contains("llamo")){ // Se obtiene el texto y luego se compara
            sendTextMessageAsync("Es un placer. Para celebrar que nos hemos conocido, te propongo un juego, *¿Quieres jugar?*");
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}