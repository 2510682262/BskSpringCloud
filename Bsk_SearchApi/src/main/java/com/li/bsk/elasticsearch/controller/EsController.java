package com.li.bsk.elasticsearch.controller;

import com.li.bsk.common.vo.ResultVo;
import com.li.bsk.elasticsearch.Provider.EsProvider;
import com.li.bsk.elasticsearch.service.EsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "搜索相关操作")
public class EsController {

    @Autowired
    private EsService esService;

    @PostMapping("esSave.do")
    @ApiOperation ("新增数据")
    public ResultVo save(String indexName, String type, String id, String json){
        System.out.println (json);
        return esService.save (indexName, type, id, json);
    }

    @GetMapping("esSingle.do")
    @ApiOperation ("查询单个数据")
    public ResultVo single(String indexName, String type, String id){
        return esService.querySingle (indexName, type, id);
    }

    @GetMapping("esLike.do")
    @ApiOperation ("模糊查询")
    public ResultVo like(String indexName, String type, String field, String value, int page, int limit){
        return esService.queryLike (indexName, type, field, value, page, limit);
    }
}
