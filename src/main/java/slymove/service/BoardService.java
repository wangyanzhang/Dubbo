package slymove.service;

import com.liby.slymove.model.BoardModel;
import com.liby.slymove.model.CardModel;
import com.liby.slymove.utils.JsonParam;

import java.util.List;

public interface BoardService {
    List<BoardModel> queryBoradInfo(JsonParam param);
    List<CardModel> queryBoradCardInfo(JsonParam param);
    List<CardModel> queryUserCardInfo(JsonParam param);
    void insertUserCardInfo(JsonParam param);
    void deleteUserCardInfo(JsonParam param);
    boolean isUserCodeCardId(JsonParam param);
}
