package slymove.model;

import java.util.Date;

public class BoardInfoListModel {
    private Integer id;
    private String name;
    private Date create_time;
    private Integer orderNum;

    public BoardInfoListModel() {
    }

    public BoardInfoListModel(Integer id, String name, Date create_time, Integer orderNum) {
        this.id = id;
        this.name = name;
        this.create_time = create_time;
        this.orderNum = orderNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "BoardInfoListModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", create_time=" + create_time +
                ", orderNum=" + orderNum +
                '}';
    }
}
