package es.codegym.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static es.codegym.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "MonaBot_bot";
    public static final String TOKEN = "Borrador por seguridad";

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
        // TODO: escribiremos la funcionalidad principal del bot aquí}
        String messageText = getMessageText().toLowerCase(); // Se obtiene el texto y ajusta a minúsculas

        if(messageText.equals("/start")){ // Se obtiene el texto y luego se compara
            setUserGlory(0); // Para iniciar el puntaje del jugador con puntaje 0
            sendPhotoMessageAsync("step_1_pic"); // Envía una foto en específico, y no es necesario escribir la extensión
            sendTextMessageAsync(STEP_1_TEXT, Map.of("Hackear la nevera","step_1_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_1_btn")){ // Ayuda a identificar el click en el botón
            setUserGlory(20); // Le da 20 puntos al jugador

            sendPhotoMessageAsync("step_2_pic");

            sendTextMessageAsync(STEP_2_TEXT,
                Map.of("¡Tomar una salchicha! +20 de fama", "step_2_btn",
                        "¡Tomar un pescado! +20 de fama", "step_2_btn",
                        "¡Tirar una lata de pepinillos! +20 de fama", "step_2_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_2_btn")){ // Ayuda a identificar el click en el botón
            setUserGlory(20); // Le da 20 puntos al jugador

            sendPhotoMessageAsync("step_3_pic");

            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Hackear al robot aspiradora", "step_3_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_3_btn")){ // Ayuda a identificar el click en el botón
            setUserGlory(30); // Le da 30 puntos al jugador

            sendPhotoMessageAsync("step_4_pic");


            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("¡Enviar al robot aspiradora! +30 de fama", "step_4_btn",
                            "¡Dar un paseo en el robot aspiradora! +30 de fama", "step_4_btn",
                            "¡Huir del robot aspiradora! +30 de fama", "step_4_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_4_btn")){ // Ayuda a identificar el click en el botón
            setUserGlory(30);

            sendPhotoMessageAsync("step_5_pic");


            sendTextMessageAsync(STEP_5_TEXT, Map.of("¡Ponerte la GoPro! +40 de fama", "step_5_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_5_btn")){ // Ayuda a identificar el click en el botón

            setUserGlory(40);

            sendPhotoMessageAsync("step_6_pic");

            sendTextMessageAsync(STEP_6_TEXT, Map.of("¡Un nuevo juguete +40 de fama", "step_6_btn",
                    "¡Un sobre de churú! +40 de fama", "step_6_btn",
                    "¡Un nuevo amigo! +40 de fama", "step_6_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_6_btn")){ // Ayuda a identificar el click en el botón

            setUserGlory(40);

            sendPhotoMessageAsync("step_7_pic");

            sendTextMessageAsync(STEP_7_TEXT, Map.of("¡Hackear la contraseña!", "step_7_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_7_btn")){ // Ayuda a identificar el click en el botón

            setUserGlory(50); // Le da 50 puntos al jugador

            sendPhotoMessageAsync("step_8_pic");

            sendTextMessageAsync(STEP_7_TEXT, Map.of("¡Salir al patio!", "step_8_btn"));
        }

        if(getCallbackQueryButtonKey().equals("step_8_btn")){ // Ayuda a identificar el click en el botón

            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(FINAL_TEXT, Map.of());
        }

        if(messageText.contains("hola")){ // Se obtiene el texto y luego se compara
            sendTextMessageAsync("¿Qué tal, cuál es tu nombre?");
        }

        if(messageText.contains("nombre") || messageText.contains("me llamo")){ // Se obtiene el texto y luego se compara
            sendTextMessageAsync("Es un placer. Para celebrar que nos hemos conocido, te propongo un juego, *¿Quieres jugar?*");
        }
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}