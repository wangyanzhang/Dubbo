package slymove.model;

import java.util.ArrayList;
import java.util.List;

public class BoardModel {
    private int board_id;
    private String board_name;
    private int orderNum;
    private List<CardModel> cardModels = new ArrayList<>();

    public int getBoard_id() {
        return board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

    public String getBoard_name() {
        return board_name;
    }

    public void setBoard_name(String board_name) {
        this.board_name = board_name;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public List<CardModel> getCardModels() {
        return cardModels;
    }

    public void setCardModels(List<CardModel> cardModels) {
        this.cardModels = cardModels;
    }
}
