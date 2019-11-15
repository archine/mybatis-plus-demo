package com.gjing.project.mybatisplus.controller;

import cn.gjing.tools.common.annotation.Exclude;
import cn.gjing.tools.common.annotation.NotNull;
import cn.gjing.tools.common.result.PageResult;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gjing.project.mybatisplus.domain.dto.EmployeeDTO;
import com.gjing.project.mybatisplus.domain.vo.EmployeeVO;
import com.gjing.project.mybatisplus.service.EmployeeService;
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
@Api(tags = "员工相关功能")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @PostMapping("/employee")
    @ApiOperation("添加员工")
    @NotNull
    public ResponseEntity saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.saveEmployee(employeeDTO);
        return ResponseEntity.ok("添加成功");
    }

    @DeleteMapping("/employee/{id}")
    @ApiOperation("根据ID删除员工")
    public ResponseEntity deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteById(id);
        return ResponseEntity.ok("删除成功");
    }

    @PutMapping("/employee")
    @ApiOperation("更新员工信息")
    @NotNull
    public ResponseEntity updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.updateById(employeeDTO);
        return ResponseEntity.ok("更新成功");
    }

    @GetMapping("/employee_page")
    @ApiOperation("分页查询员工")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "employeeName", value = "员工姓名", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "companyId", value = "公司id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "deptId", value = "部门id", dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "Long", paramType = "query"),
            @ApiImplicitParam(name = "row", value = "条数", required = true, dataType = "Long", paramType = "query")
    })
    @NotNull
    public ResponseEntity<PageResult<List<EmployeeVO>>> pageEmployee(@Exclude String employeeName, @Exclude Long companyId, @Exclude Long deptId,
                                                                     Long page, Long row) {
        return ResponseEntity.ok(employeeService.pageEmployee(employeeName, companyId, deptId, new Page<>(page, row)));
    }
}
