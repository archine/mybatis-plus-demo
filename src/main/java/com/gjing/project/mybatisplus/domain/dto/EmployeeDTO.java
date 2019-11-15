package com.gjing.project.mybatisplus.domain.dto;

import com.gjing.project.mybatisplus.enums.Gender;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Gjing
 **/
@Data
@ApiModel("员工传输对象")
public class EmployeeDTO {
    @ApiModelProperty(name = "id", value = "员工id,添加的时候无需传")
    private Long id;

    @ApiModelProperty(name = "employeeName", value = "员工姓名,长度不能超过10", required = true)
    private String employeeName;

    @ApiModelProperty(name = "gender", value = "性别", required = true)
    private Gender gender;

    @ApiModelProperty(name = "companyId", value = "公司Id", required = true)
    private Long companyId;

    @ApiModelProperty(name = "deptId", value = "部门Id", required = true)
    private Long deptId;
}
