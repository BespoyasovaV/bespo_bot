package com.example.bespo_bot.bot;

import com.example.bespo_bot.exception.ServiceException;
import com.example.bespo_bot.service.ExchangeRatesService;
import com.example.bespo_bot.service.mplementation.ExchangeRatesServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.time.LocalDate;

/**
 * @author BespoyasovaV
 */
@Component
public class BespoBot extends TelegramLongPollingBot {
    @Autowired
    private ExchangeRatesServiceImplementation exchangeRatesServiceImplementation;
    private static final Logger logger = LoggerFactory.getLogger(BespoBot.class);
    private static final String START = "/start";
    private static final String USD = "/usd";
    private static final String EUR = "/eur";
    private static final String CNY = "/cny";
    private static final String HELP = "/help";


    public BespoBot(@Value("${bot.token}") String botToken) {
        super(botToken);
    }

//    @Override
//    public String getBotToken() {
//        return "6586180223:AAF5KuPpwVapr25jSqZ3Tkhe65K6GdlMp24";
//    }

    //обработчик пользовательских команд
    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText()) {
            return;
        }
        String message = update.getMessage().getText();
        Long chatId = update.getMessage().getChatId();
        switch (message) {
            case START -> {
                String userName = update.getMessage().getChat().getUserName();
                startCommand(chatId, userName);
            }
            case USD -> {
                usdCommand(chatId);
            }
            case EUR -> {
                eurCommand(chatId);
            }
            case CNY -> {
                cnyCommand(chatId);
            }
            case HELP -> {
                helpCommand(chatId);
            }
            default -> unknownCommand(chatId);
        }

    }

    @Override
    public String getBotUsername() {
        return "bespo_bot";
    }

    private void sendMessage(Long chatId, String text) {
        String chatIdStr = String.valueOf(chatId);
        SendMessage sendMessage = new SendMessage(chatIdStr, text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            logger.error("ошибка отправки сообщения", e);
        }
    }

    private void startCommand(Long chatId, String userName) {
        String text = "";
        if (userName.contains("Xgage02")) {
            text = "" +
                    "Добро пожаловать  в бот, %s !\n" +
                    "\n сначала я дружила с тобой только из-за Юли и Никиты, а теперь еще из-за денег!" +
                    "Здесь вы сможете узнать официальные курсы валют на сегодня, установленные в ЦБ РФ.\n" +
                    " \n Для этого используйте команды:" +
                    "\n " +
                    "\n /usd -курс доллара" +
                    "\n /eur -курс евро" +
                    "\n /cny -курс юаня" +
                    "\n" +
                    "\n Дополнительные команды: " +
                    "\n /help - получение справки" +
                    "\n " +
                    "\n  Если вам понравился бот, купите мне макбук, функцию перевода денег я сделаю чуть позже, пока можешь скинуть на карту" +
                    "";
        }
        if (userName.contains("vikatisovsemkuku")) {
            text = "" +
                    "Добро пожаловать  в бот, %s !\n" +
                    "\n жду тебя завра на кальян, можем выпить вина и опять обсудить всех на свете" +
                    "Здесь вы сможете узнать официальные курсы валют на сегодня, установленные в ЦБ РФ.\n" +
                    " \n Для этого используйте команды:" +
                    "\n " +
                    "\n /usd -курс доллара" +
                    "\n /eur -курс евро" +
                    "\n /cny -курс юаня" +
                    "\n" +
                    "\n Дополнительные команды: " +
                    "\n /help - получение справки" +
                    "\n " +
                    "\n  Если вам понравился бот, купите мне макбук, функцию перевода денег я сделаю чуть позже, пока можешь скинуть на карту" +
                    "";
        }
        if (userName.contains("Nikita_Bespoyasov")) {
            text = "" +
                    "Добро пожаловать  в бот, %s !\n" +
                    "\n зацени, какой приколдес я слепила, можно еще много всего разного сюда добавить, есть идеи?\n" +
                    "Здесь вы сможете узнать официальные курсы валют на сегодня, установленные в ЦБ РФ.\n" +
                    " \n Для этого используйте команды:" +
                    "\n " +
                    "\n /usd -курс доллара" +
                    "\n /eur -курс евро" +
                    "\n /cny -курс юаня" +
                    "\n" +
                    "\n Дополнительные команды: " +
                    "\n /help - получение справки" +
                    "\n " +
                    "\n  Если вам понравился бот, купите мне макбук, функцию перевода денег я сделаю чуть позже, пока можешь скинуть на карту" +
                    "";
        }
        if (userName.contains("hryhryhryn")) {
            text = "" +
                    "Добро пожаловать  в бот, %s !\n" +
                    "\n профессиАнально перевожу деньги"
                    + "\n никогда не заведу 2 кошек" + "\n живу как инстасамка, за деньги  Да" +
                    "\n зацени, какой приколдес я слепила, можно еще много всего разного сюда добавить, есть идеи?" +
                    "Здесь вы сможете узнать официальные курсы валют на сегодня, установленные в ЦБ РФ.\n" +
                    " \n Для этого используйте команды:" +
                    "\n " +
                    "\n /usd -курс доллара" +
                    "\n /eur -курс евро" +
                    "\n /cny -курс юаня" +
                    "\n" +
                    "\n Дополнительные команды: " +
                    "\n /help - получение справки" +
                    "\n " +
                    "\n  Если вам понравился бот, купите мне макбук, функцию перевода денег я сделаю чуть позже, пока можешь скинуть на карту" +
                    "";
        } else {
            text = "" +
                    "Добро пожаловать в бот, %s !\n" +

                    "Здесь вы сможете узнать официальные курсы валют на сегодня, установленные в ЦБ РФ.\n" +
                    " \n Для этого используйте команды:" +
                    "\n " +
                    "\n /usd -курс доллара" +
                    "\n /eur -курс евро" +
                    "\n /cny -курс юаня" +
                    "\n" +
                    "\n Дополнительные команды: " +
                    "\n /help - получение справки" +
                    "\n " +
                    "\n  Если вам понравился бот, то ..." +
                    "";
        }
        String stringFormatter = String.format(text, userName);
        sendMessage(chatId, stringFormatter);
    }

    private void usdCommand(Long chatId) {
        String formattedText;
        try {
            String usd = exchangeRatesServiceImplementation.getUSDExchangeRate();
            String text = "Курс доллара на %s составляет %s рублей";
            formattedText = String.format(text, LocalDate.now(), usd);
        } catch (ServiceException e) {
            logger.error("ошибка получения курса доллара", e);
            formattedText = "Не удалось получить текущий курс доллара, попробуйте позже.";
        }
        sendMessage(chatId, formattedText);

    }

    private void eurCommand(Long chatId) {
        String formattedText;
        try {
            String eur = exchangeRatesServiceImplementation.getEURExchangeRate();
            String text = "Курс евро на %s составляет %s рублей";
            formattedText = String.format(text, LocalDate.now(), eur);
        } catch (ServiceException e) {
            logger.error("ошибка получения курса евро", e);
            formattedText = "Не удалось получить текущий курс евро, попробуйте позже.";
        }
        sendMessage(chatId, formattedText);

    }

    private void cnyCommand(Long chatId) {
        String formattedText;
        try {
            String cny = exchangeRatesServiceImplementation.getCNYExchangeRate();
            String text = "Курс юаня на %s составляет %s рублей";
            formattedText = String.format(text, LocalDate.now(), cny);
        } catch (ServiceException e) {
            logger.error("ошибка получения курса юаня", e);
            formattedText = "Не удалось получить текущий курс юаня, попробуйте позже.";
        }
        sendMessage(chatId, formattedText);

    }

    private void helpCommand(Long chatId) {
        String text = " Справочная информация по боту \n" +
                "\n /usd -курс доллара" +
                "\n /eur -курс евро" +
                "\n /cny -курс юаня";
        sendMessage(chatId, text);
    }

    private void unknownCommand(Long chatId) {
        String text = "мда, треш. \n" +
                "Не удалось распознать команду, ребята, читайте внимательнее..." + " \n помогите себе сами /help";
        sendMessage(chatId, text);
    }
}
