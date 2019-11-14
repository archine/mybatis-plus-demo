package com.gjing.project.mybatisplus.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Gjing
 **/
@ApiModel("部门视图")
@Data
public class DepartmentVO {
    @ApiModelProperty("部门id")
    private Long id;

    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty("公司名称")
    private String companyName;

    @ApiModelProperty("公司id")
    private Long companyId;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
