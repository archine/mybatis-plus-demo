package com.gjing.project.mybatisplus.domain.vo;

import com.gjing.project.mybatisplus.enums.Gender;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Gjing
 **/
@Data
@ApiModel("员工视图")
public class EmployeeVO {
    @ApiModelProperty("员工id")
    private Long id;

    @ApiModelProperty("员工姓名")
    private String employeeName;

    @ApiModelProperty("性别")
    private Gender gender;

    @ApiModelProperty("公司Id")
    private Long companyId;

    @ApiModelProperty("公司名称")
    private String companyName;

    @ApiModelProperty("部门Id")
    private Long deptId;

    @ApiModelProperty("部门名称")
    private String deptName;
}
