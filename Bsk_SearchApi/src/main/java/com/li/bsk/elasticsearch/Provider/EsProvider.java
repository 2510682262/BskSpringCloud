package com.li.bsk.elasticsearch.Provider;

import com.li.bsk.common.util.ResultUtil;
import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.elasticsearch.service.EsService;
import com.li.bsk.elasticsearch.transport.TransportBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EsProvider implements EsService {

    @Autowired
    private TransportBean transportBean;

    @Override
    public ResultVo save(String index, String type, String id, String data) {
        return ResultUtil.exec(transportBean.save(index,type,id,data),"操作完成",null);
    }

    @Override
    public ResultVo saveBatch(String index, String type, Map<String, String> data) {
        return ResultUtil.exec(transportBean.saveBatch(index,type,data),"操作完成",null);
    }

    @Override
    public ResultVo update(String index, String type, String id, String data) {
        return ResultUtil.exec(transportBean.update(index,type,id,data),"操作完成",null);
    }

    @Override
    public ResultVo delete(String index, String type, String id) {
        return ResultUtil.exec(transportBean.delete(index,type,id),"操作完成",null);
    }

    @Override
    public ResultVo deleteBatch(String index, String type, List<String> ids) {
        return ResultUtil.exec(transportBean.deleteBatch(index,type,ids),"操作完成",null);
    }

    @Override
    public ResultVo querySingle(String index, String type, String id) {
        String json=transportBean.queryById(index,type,id);
        if(json!=null){
            return ResultUtil.exec(true,"OK",json);
        }else {
            return ResultUtil.exec(false,"ERROR",null);
        }
    }

    @Override
    public ResultVo queryLike(String index, String type, String field, String value, int page, int limit) {
        int i=(page-1)*limit;
        return ResultUtil.exec(true,"OK",transportBean.queryLike(index, type, field, value, i, limit));
    }
}
