package com.black.jack.dto;

import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class Player {
    private String name;
    private Integer amount;
    private Integer numberOfGames;
    private Integer numberOfWinGames;
    private List<Card> hand = new ArrayList<>();

}
