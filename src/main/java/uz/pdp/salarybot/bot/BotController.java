package uz.pdp.salarybot.bot;

import com.pengrad.telegrambot.model.Contact;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import uz.pdp.salarybot.entity.TelegramUser;

@Service
@RequiredArgsConstructor
public class BotController {
    private final BotServiceI botServiceI;
    @Async
    public void handle(Update update) {
        if (update.message()!=null){
            Message message = update.message();
            TelegramUser tgUser = botServiceI.getOrCreateTelegramUser(message.chat().id());
            if (message.text()!=null){
                String text = message.text();
                if (text.equals("/start")){
                    botServiceI.acceptStartSendShareContact(message,tgUser);
                }
            } else if (message.contact()!=null) {
                Contact contact = message.contact();
                botServiceI.acceptContactConfirmIdentity(contact,tgUser);
            }
        }else if (update.callbackQuery()!=null){

        }
    }
}
