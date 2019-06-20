package slymove.web;

import com.liby.slymove.model.CardModel;
import com.liby.slymove.service.BoardInfoListService;
import com.liby.slymove.utils.JsonData;
import com.liby.slymove.utils.JsonParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/boardinfo")

public class BoardInfoListController {

    @Autowired
    private BoardInfoListService boardInfoListService;

    /*查询一条数据*/
    @RequestMapping("/queryOne")
    public JsonData queryOne(HttpServletRequest request, HttpServletResponse response) {
        JsonData jsonData = new JsonData();
        try {
            JsonParam param = JsonParam.populateReqBean(request);
            List list = boardInfoListService.queryOne(param);
            jsonData.setData(list);
            jsonData.setStatus(JsonData.SUCCESS);
        } catch (Exception e) {
            jsonData.setErrorMessage("查询数据库错误");
        }
        return jsonData;
    }

    /*查询全部*/
    @RequestMapping("/queryAll")
    public JsonData queryAll(HttpServletRequest request, HttpServletResponse response) {
        JsonData jsonData = new JsonData();
        JsonParam param = JsonParam.populateReqBean(request);
        try {
            List<CardModel> list = boardInfoListService.queryAll(param);
            // jsonData.setData(list);
            jsonData.setStatus(JsonData.SUCCESS);
        } catch (Exception e) {
            jsonData.setStatus(JsonData.ERROR);
            jsonData.setErrorMessage("查询数错误");
        }
        jsonData.setCode("200");
        return jsonData;
    }

    /*添加*/


    /**
     * 根据id删除一条信息
     */
    @RequestMapping("/deleteOne")
    public JsonData deleteOne(HttpServletRequest request, HttpServletResponse response){
        JsonData jsonData = new JsonData();
        JsonParam param = JsonParam.populateReqBean(request);
        try{
            boardInfoListService.deleteOne(param);

            jsonData.setStatus(JsonData.SUCCESS);
        }catch (Exception e){
            jsonData.setStatus(JsonData.ERROR);
            jsonData.setErrorMessage("删除失败");
        }
        jsonData.setCode("200");
        return jsonData;
    }
}
