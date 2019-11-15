package com.gjing.project.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gjing.project.mybatisplus.domain.entity.Employee;
import com.gjing.project.mybatisplus.domain.vo.EmployeeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

/**
 * @author Gjing
 **/
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
    /**
     * 通过员工姓名进行查询
     *
     * @param employeeName 员工姓名
     * @return Employee
     */
    @Select("select * from employee as e where e.employee_name = #{employeeName}")
    Employee findByName(String employeeName);

    /**
     * 通过员工ID进行查询
     * @param id 员工id
     * @return Optional<Employee>
     */
    @Select("select * from employee as e where e.id = #{id}")
    Optional<Employee> findById(Long id);

    /**
     * 分页查询
     * @param page 分页对象
     * @param employeeName 员工姓名
     * @param companyId 公司id
     * @param deptId 部门id
     * @return IPage<EmployeeVO>
     */
    IPage<EmployeeVO> pageEmployee(Page<EmployeeVO> page, String employeeName, Long companyId, Long deptId);
}
