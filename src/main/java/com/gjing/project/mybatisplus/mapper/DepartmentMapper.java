package com.gjing.project.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gjing.project.mybatisplus.domain.entity.Department;
import com.gjing.project.mybatisplus.domain.vo.DepartmentVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Gjing
 **/
@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {
    /**
     * 通过名称查询
     *
     * @param departmentName 部门名
     * @return Department
     */
    @Select("select * from department as d where d.dept_name = #{departmentName}")
    Department findByName(String departmentName);

    /**
     * 分页查询部门列表
     *
     * @param page      分页对象
     * @param companyId 公司id
     * @param deptName  部门名
     * @return IPage<DepartmentVO>
     */
    IPage<DepartmentVO> findPage(Page<DepartmentVO> page, Long companyId, String deptName);
}
