package com.gjing.project.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gjing.project.mybatisplus.domain.entity.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

/**
 * @author Gjing
 **/
@Mapper
public interface CompanyMapper extends BaseMapper<Company> {
    /**
     * 通过名称查找
     * @param companyName 公司名称
     * @return Company
     */
    @Select("select * from company as c where c.company_name = #{companyName}")
    Company findByName(String companyName);

    /**
     * 根据ID查询
     * @param id id
     * @return Optional<Company>
     */
    @Select("select * from company as c where c.id = #{id}")
    Optional<Company> findById(Long id);
}
