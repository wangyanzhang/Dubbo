package slymove.service;

import com.liby.slymove.dao.impl.BoardInfoListDaoImpl;
import com.liby.slymove.model.BoardInfoListModel;
import com.liby.slymove.utils.JsonParam;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service

public class BoardInfoListService {
        // 查询一条
        public List queryOne(JsonParam id) {
            String sql = "select * from tm_app_board_info_list where id = ?";
            Object[] paramsValue = {id};
            BoardInfoListDaoImpl dao = new BoardInfoListDaoImpl();
            List<BoardInfoListModel> list = dao.query(sql, paramsValue, BoardInfoListModel.class);
            if (list.size() > 0) {
                BoardInfoListModel model = list.get(0);
                System.out.println(model);
            }
            return  list;
        }

        // 查询全部
        public List queryAll(JsonParam param) {
            String sql = "select * from tm_app_board_info_list";
            Object[] paramsValue = null;
            BoardInfoListDaoImpl dao = new BoardInfoListDaoImpl();
            List<BoardInfoListModel> list = dao.query(sql, paramsValue, BoardInfoListModel.class);
            if (list.size() > 0) {
                for (BoardInfoListModel boardInfoListModel : list) {
                    System.out.println(boardInfoListModel);
                }
            }
            return  list;
        }

        // 删除一条
        public void deleteOne(JsonParam id ) {
            String sql = "delete from tm_app_board_info_list where id = ?";
            Object[] paramsValue = {id};
            BoardInfoListDaoImpl dao = new BoardInfoListDaoImpl();
            dao.update(sql, paramsValue);
        }

        // 新增一条
        public void addInfo(BoardInfoListModel model) {
            model = new BoardInfoListModel(null, "测试", new Date(), 5);
            String sql = "insert into tm_app_board_info_list values(?,?,?,?)";
            Object[] paramsValue = {model.getId(),model.getName(),model.getCreate_time(),model.getOrderNum()};
            BoardInfoListDaoImpl dao = new BoardInfoListDaoImpl();
            dao.update(sql, paramsValue);
        }

        // 修改一条(创建时间不更新)
        // 必须有一条要更新
        public void update() {

            BoardInfoListModel model = new BoardInfoListModel(5, null, null, null);
            StringBuffer sql = new StringBuffer(" update tm_app_board_info_list set ");
            List<Object> paramsValue = new ArrayList<>();

            if(model.getName() != null && !"".equals(model.getName())) {
                sql.append("name = ?,");
                paramsValue.add(model.getName());
            }

            if(model.getOrderNum() != null && !"".equals(model.getName())) {
                sql.append("orderNum = ?,");
                paramsValue.add(model.getOrderNum());
            }

            // 如果名字和订单号都是null，跳出
            if (paramsValue.size() == 0) {
                return;
            }
            // 去掉逗号
            sql = new StringBuffer(sql.substring(0, sql.length() - 1));
            sql.append(" where id = ? ");
            paramsValue.add(model.getId());
            BoardInfoListDaoImpl dao = new BoardInfoListDaoImpl();
            dao.update(sql.toString(), paramsValue.toArray());
        }

}
