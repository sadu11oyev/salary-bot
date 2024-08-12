package uz.pdp.salarybot.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Contact;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.salarybot.entity.TelegramUser;
import uz.pdp.salarybot.entity.enums.TelegramState;
import uz.pdp.salarybot.repo.TelegramUserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BotService implements BotServiceI {
    private final TelegramUserRepository telegramUserRepository;
    private final BotUtils botUtils;
    private final TelegramBot telegramBot;

    @Override
    public TelegramUser getOrCreateTelegramUser(Long chatId) {
        Optional<TelegramUser> byChatId = telegramUserRepository.findByChatId(chatId);
        if (byChatId.isPresent()){
            return byChatId.get();
        }else {
            TelegramUser newUser = new TelegramUser(chatId);
            telegramUserRepository.save(newUser);
            return newUser;
        }
    }

    @Override
    public void acceptStartSendShareContact(Message message, TelegramUser tgUser) {
        SendMessage sendMessage = new SendMessage(message.chat().id(),BotConstant.PLEASE_SHARE_CONTACT);
        sendMessage.replyMarkup(botUtils.generateContactButton());
        telegramBot.execute(sendMessage);
        tgUser.setState(TelegramState.SHARE_CONTACT);
        telegramUserRepository.save(tgUser);
    }

    @Override
    public void acceptContactConfirmIdentity(Contact contact, TelegramUser tgUser) {
        String phoneNumber = contact.phoneNumber();


    }
}
