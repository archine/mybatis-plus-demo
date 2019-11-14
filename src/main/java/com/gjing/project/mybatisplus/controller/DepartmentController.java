package com.gjing.project.mybatisplus.controller;

import cn.gjing.tools.common.annotation.Exclude;
import cn.gjing.tools.common.annotation.NotNull;
import cn.gjing.tools.common.result.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gjing.project.mybatisplus.domain.vo.DepartmentVO;
import com.gjing.project.mybatisplus.service.DepartmentService;
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
@Api(tags = "部门相关功能")
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;

    @PostMapping("/department")
    @ApiOperation("添加部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "deptName", value = "部门名", required = true, dataType = "String", paramType = "query")
    })
    @NotNull
    public ResponseEntity saveDepartment(Long companyId, String deptName) {
        departmentService.saveDepartment(companyId, deptName);
        return ResponseEntity.ok("添加成功");
    }

    @DeleteMapping("/department/{id}")
    @ApiOperation("删除部门")
    public ResponseEntity deleteDepartment(@PathVariable("id") Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("删除成功");
    }

    @PutMapping("/department")
    @ApiOperation("更新部门")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "deptId", value = "部门id", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "deptName", value = "部门名", required = true, dataType = "String", paramType = "query")
    })
    @NotNull
    public ResponseEntity updateDepartment(Long deptId, String deptName) {
        departmentService.updateDepartment(deptId, deptName);
        return ResponseEntity.ok("更新成功");
    }

    @GetMapping("/department_page")
    @ApiOperation("分页查询部门列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "companyId", value = "公司id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "deptName", value = "部门名", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "long", paramType = "query"),
            @ApiImplicitParam(name = "row", value = "条数", required = true, dataType = "long", paramType = "query")
    })
    @NotNull
    public ResponseEntity<PageResult<List<DepartmentVO>>> pageDepartment(@Exclude Long companyId, @Exclude String deptName, Long page, Long row) {
        return ResponseEntity.ok(departmentService.pageDept(new Page<>(page, row), companyId, deptName));
    }
}
