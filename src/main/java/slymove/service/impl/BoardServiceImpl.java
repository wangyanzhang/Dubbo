package slymove.service.impl;

import com.liby.slymove.dao.BoardDao;
import com.liby.slymove.model.BoardModel;
import com.liby.slymove.model.CardModel;
import com.liby.slymove.service.BoardService;
import com.liby.slymove.utils.JsonParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    Logger logger = LoggerFactory.getLogger(BoardServiceImpl.class);
    @Autowired
    BoardDao boardDao ;
    @Override
    public List<BoardModel> queryBoradInfo(JsonParam param) {
        return boardDao.queryBoradInfo(param);
    }

    @Override
    public List<CardModel> queryBoradCardInfo(JsonParam param) {
        return boardDao.queryBoradCardInfo(param);
    }
    @Override
    public List<CardModel> queryUserCardInfo(JsonParam param) {
        return boardDao.queryUserCardInfo(param);

    }
    @Transactional
    @Override
    public void insertUserCardInfo(JsonParam param) {
         boardDao.insertUserCardInfo(param);
    }
    @Transactional
    @Override
    public void deleteUserCardInfo(JsonParam param) {
         boardDao.deleteUserCardInfo(param);
    }
    @Override
    public boolean isUserCodeCardId(JsonParam param) {
         int i = boardDao.isUserCodeCardId(param);

        return i == 1 ? false : true;

    }
}
