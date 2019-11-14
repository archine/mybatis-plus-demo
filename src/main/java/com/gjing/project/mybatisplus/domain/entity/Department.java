package com.gjing.project.mybatisplus.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gjing.project.mybatisplus.domain.BaseEntity;
import lombok.*;

/**
 * @author Gjing
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("department")
@EqualsAndHashCode(callSuper = true)
public class Department extends BaseEntity {
    /**
     * 部门名称
     */
    @TableField("dept_name")
    private String deptName;

    /**
     * 公司id
     */
    @TableField("company_id")
    private Long companyId;
}
