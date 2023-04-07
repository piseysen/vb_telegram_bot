package com.vb.telegram.bot.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Pisey Sen
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostMessage {

    private Long chatId;
    private String text;
}
