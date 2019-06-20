package slymove.web;

import com.liby.slymove.model.BoardModel;
import com.liby.slymove.model.CardModel;
import com.liby.slymove.service.BoardService;
import com.liby.slymove.utils.JsonData;
import com.liby.slymove.utils.JsonParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    Logger logger = LoggerFactory.getLogger(BoardController.class);
    @Autowired
    BoardService boardService ;
    @PostMapping("/queryBoradModule")
    public JsonData qryReferenceById(HttpServletRequest request, HttpServletResponse response){
        JsonData jsonData = new JsonData();
        JsonParam param = JsonParam.populateReqBean(request);
        try{
            List<BoardModel> list = boardService.queryBoradInfo(param);
             jsonData.setData(list);
            jsonData.setStatus(JsonData.SUCCESS);
        }catch (Exception e){
            logger.info(e.getMessage());
            jsonData.setStatus(JsonData.ERROR);
            jsonData.setErrorMessage("数据库错误，查询数据库错误");
        }
        jsonData.setCode("200");
        return jsonData;
    }
    @PostMapping("/queryBoradCardModule")
    public JsonData queryBoradCardModule(HttpServletRequest request, HttpServletResponse response){
        JsonData jsonData = new JsonData();
        JsonParam param = JsonParam.populateReqBean(request);
        try{
            List<CardModel> list = boardService.queryBoradCardInfo(param);
             jsonData.setData(list);
            jsonData.setStatus(JsonData.SUCCESS);
        }catch (Exception e){
            logger.info(e.getMessage());
            jsonData.setStatus(JsonData.ERROR);
            jsonData.setErrorMessage("数据库错误，查询数据库错误");
        }
        jsonData.setCode("200");
        return jsonData;
    }
    @PostMapping("/queryUserCardModule")
    public JsonData queryUserCardModule(HttpServletRequest request, HttpServletResponse response){
        JsonData jsonData = new JsonData();
        JsonParam param = JsonParam.populateReqBean(request);
        try{
            List<CardModel> list = boardService.queryUserCardInfo(param);
             jsonData.setData(list);
            jsonData.setStatus(JsonData.SUCCESS);
        }catch (Exception e){
            logger.info(e.getMessage());
            jsonData.setStatus(JsonData.ERROR);
            jsonData.setErrorMessage("数据库错误，查询数据库错误");
        }
        jsonData.setCode("200");
        return jsonData;
    }
    @PostMapping("/insertUserCardInfo")
    public JsonData insertUserCardInfo(HttpServletRequest request, HttpServletResponse response){
        JsonData jsonData = new JsonData();
        JsonParam param = JsonParam.populateReqBean(request);
        try{
           /* boolean falg = boardService.isUserCodeCardId(param);
            if (!falg) {
                jsonData.setStatus(JsonData.ERROR);
                jsonData.setErrorMessage("关注失败，参数无法匹配");
                return jsonData;

            }*/
            boardService.insertUserCardInfo(param);

            jsonData.setStatus(JsonData.SUCCESS);
        }catch (Exception e){
            logger.info(e.getMessage());
            jsonData.setStatus(JsonData.ERROR);
            jsonData.setErrorMessage("数据库错误，关注失败");
        }
        jsonData.setCode("200");
        return jsonData;
    }
    @PostMapping("/deleteUserCardInfo")
    public JsonData deleteUserCardInfo(HttpServletRequest request, HttpServletResponse response){
        JsonData jsonData = new JsonData();
        JsonParam param = JsonParam.populateReqBean(request);
        try{
          /*  boolean falg = boardService.isUserCodeCardId(param);
            if (!falg) {
                jsonData.setStatus(JsonData.ERROR);
                jsonData.setErrorMessage("取消失败，参数无法匹配");
                return jsonData;

            }*/
              boardService.deleteUserCardInfo(param);

            jsonData.setStatus(JsonData.SUCCESS);
        }catch (Exception e){
            logger.info(e.getMessage());
            jsonData.setStatus(JsonData.ERROR);
            jsonData.setErrorMessage("数据库错误，取消失败");
        }
        jsonData.setCode("200");
        return jsonData;
    }

}
