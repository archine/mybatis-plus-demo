package com.gjing.project.mybatisplus.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gjing.project.mybatisplus.domain.BaseEntity;
import com.gjing.project.mybatisplus.enums.Gender;
import lombok.*;

/**
 * @author Gjing
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("employee")
@EqualsAndHashCode(callSuper = true)
public class Employee extends BaseEntity {
    /**
     * 员工姓名
     */
    @TableField("employee_name")
    private String employeeName;

    /**
     * 员工性别
     */
    @TableField("employee_gender")
    private Gender gender;

    /**
     * 公司ID
     */
    @TableField("company_id")
    private Long companyId;

    /**
     * 部门ID
     */
    @TableField("dept_id")
    private Long deptId;
}
