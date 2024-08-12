package uz.pdp.salarybot.bot;

import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import org.springframework.stereotype.Service;

@Service
public class BotUtils {
    public Keyboard generateContactButton(){
        return new ReplyKeyboardMarkup(
                new KeyboardButton(BotConstant.SHARE_CONTACT)
                        .requestContact(true)
        ).resizeKeyboard(true);
    }
}
