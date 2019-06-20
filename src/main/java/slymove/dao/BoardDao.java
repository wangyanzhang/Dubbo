package slymove.dao;

import com.liby.slymove.model.BoardModel;
import com.liby.slymove.model.CardModel;
import com.liby.slymove.utils.JsonParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardDao {
    List<BoardModel> queryBoradInfo(JsonParam param);
    List<CardModel> queryBoradCardInfo(JsonParam param);
    List<CardModel> queryUserCardInfo(JsonParam param);
   void  insertUserCardInfo(JsonParam param);
   void  deleteUserCardInfo(JsonParam param);
   int  isUserCodeCardId(JsonParam param);
}
