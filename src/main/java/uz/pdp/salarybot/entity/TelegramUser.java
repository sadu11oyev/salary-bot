package uz.pdp.salarybot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.salarybot.entity.abs.AbsEntity;
import uz.pdp.salarybot.entity.enums.TelegramState;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TelegramUser extends AbsEntity {
    private Long chatId;

    @Enumerated(EnumType.STRING)
    private TelegramState state = TelegramState.START;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public TelegramUser(Long chatId){
        this.chatId = chatId;
    }
}
