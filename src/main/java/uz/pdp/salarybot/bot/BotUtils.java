package uz.pdp.salarybot.bot;

import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static uz.pdp.salarybot.bot.BotConstant.MONTH_ARRAY;

@Service
public class BotUtils {
    public Keyboard generateContactButton(){
        return new ReplyKeyboardMarkup(
                new KeyboardButton(BotConstant.SHARE_CONTACT)
                        .requestContact(true)
        ).resizeKeyboard(true);
    }

    public Keyboard generateMonthButtons() {
        String[][] mothArray = makeArray();
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(mothArray);
        replyKeyboardMarkup.resizeKeyboard(true);
        return replyKeyboardMarkup;
    }

    private String[][] makeArray() {
        LocalDate currentDate = LocalDate.now();
        int monthNumber = currentDate.getMonthValue()-1;
        int year = currentDate.getYear()-1;
        String[] result = new String[12];

        for (int i = 0; i < 12; i++) {
            result[i]=MONTH_ARRAY[monthNumber]+" "+year;
            monthNumber++;
            if (monthNumber==12){
                monthNumber=0;
                year=year+1;
            }
        }

        monthNumber=0;
        String[][] matrix = new String[4][3];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j]=result[monthNumber];
                monthNumber++;
            }
        }
        return matrix;
    }

}
