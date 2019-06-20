package slymove.model;

import java.math.BigDecimal;

public class CardFiledModel {
    private int card_id;
    private String filed_name;
    private BigDecimal filed_value;
    private String filed_unit;
    private int orderNum;

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public String getFiled_name() {
        return filed_name;
    }

    public void setFiled_name(String filed_name) {
        this.filed_name = filed_name;
    }

    public BigDecimal getFiled_value() {
        return filed_value;
    }

    public void setFiled_value(BigDecimal filed_value) {
        this.filed_value = filed_value;
    }

    public String getFiled_unit() {
        return filed_unit;
    }

    public void setFiled_unit(String filed_unit) {
        this.filed_unit = filed_unit;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }


}
