package com.gjing.project.mybatisplus.controller;

import cn.gjing.tools.common.annotation.Exclude;
import cn.gjing.tools.common.annotation.NotNull;
import cn.gjing.tools.common.result.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gjing.project.mybatisplus.domain.entity.Company;
import com.gjing.project.mybatisplus.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Gjing
 **/
@RestController
@Api(tags = "公司相关功能")
public class CompanyController {
    @Resource
    private CompanyService companyService;

    @PostMapping("/company")
    @ApiOperation("添加公司")
    @ApiImplicitParam(name = "companyName",value = "公司名称",dataType = "String",required = true,paramType = "query")
    @NotNull
    public ResponseEntity saveCompany(String companyName) {
        companyService.saveCompany(companyName);
        return ResponseEntity.ok("添加成功");
    }

    @DeleteMapping("/company/{id}")
    @ApiOperation("删除公司")
    public ResponseEntity deleteCompany(@PathVariable("id") Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.ok("删除成功");
    }

    @PutMapping("/company")
    @ApiOperation("更新公司")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "公司Id", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "companyName", value = "公司名", required = true, dataType = "String", paramType = "query")
    })
    public ResponseEntity updateCompany(Long id, String companyName) {
        companyService.updateCompany(id, companyName);
        return ResponseEntity.ok("更新成功");
    }

    @GetMapping("/company_page")
    @ApiOperation("分页查询公司列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyName", value = "公司名", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页数", dataType = "long", required = true, paramType = "query"),
            @ApiImplicitParam(name = "row", value = "条数", dataType = "long", required = true, paramType = "query")
    })
    @NotNull
    public ResponseEntity<PageResult<List<Company>>> pageCompany(@Exclude String companyName, Long page, Long row) {
        return ResponseEntity.ok(companyService.pageCompany(companyName, new Page<>(page, row)));
    }
}
