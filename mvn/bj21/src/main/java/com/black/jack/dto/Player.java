package com.black.jack.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class Player {
    private String name;
    private Integer amount;
    private Integer numberOfGames = 0;
    private Integer numberOfWinGames = 0;
    private List<Card> hand = new ArrayList<>();

}
