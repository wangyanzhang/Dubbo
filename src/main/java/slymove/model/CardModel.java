package slymove.model;

import java.util.ArrayList;
import java.util.List;

public class CardModel {
    private int card_id;
    private String card_name;
    private int card_type;//展示模板
    private int orderNum;
    private int board_id;
    private String is_attention;//是否关注
    private String color;//默认颜色
    private List<CardFiledModel> cardFiledModels = new ArrayList<>();

    public List<CardFiledModel> getCardFiledModels() {
        return cardFiledModels;
    }

    public void setCardFiledModels(List<CardFiledModel> cardFiledModels) {
        this.cardFiledModels = cardFiledModels;
    }

    public String getIs_attention() {
        return is_attention;
    }

    public void setIs_attention(String is_attention) {
        this.is_attention = is_attention;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public String getCard_name() {
        return card_name;
    }

    public void setCard_name(String card_name) {
        this.card_name = card_name;
    }

    public int getCard_type() {
        return card_type;
    }

    public void setCard_type(int card_type) {
        this.card_type = card_type;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public int getBoard_id() {
        return board_id;
    }

    public void setBoard_id(int board_id) {
        this.board_id = board_id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
