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
@TableName("company")
@EqualsAndHashCode(callSuper = true)
public class Company extends BaseEntity {
    /**
     * 公司名称
     */
    @TableField("company_name")
    private String companyName;
}
