package uz.pdp.salarybot.bot;

import com.pengrad.telegrambot.model.Contact;
import com.pengrad.telegrambot.model.Message;
import uz.pdp.salarybot.entity.TelegramUser;

public interface BotServiceI {
    void acceptStartSendShareContact(Message message, TelegramUser tgUser);

    TelegramUser getOrCreateTelegramUser(Long id);

    void acceptContactConfirmIdentity(Contact contact, TelegramUser tgUser);
}
