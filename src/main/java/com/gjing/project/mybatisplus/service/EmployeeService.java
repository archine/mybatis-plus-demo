package com.gjing.project.mybatisplus.service;

import cn.gjing.tools.common.result.PageResult;
import cn.gjing.tools.common.util.BeanUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gjing.project.mybatisplus.domain.dto.EmployeeDTO;
import com.gjing.project.mybatisplus.domain.entity.Employee;
import com.gjing.project.mybatisplus.domain.vo.EmployeeVO;
import com.gjing.project.mybatisplus.exception.ServiceException;
import com.gjing.project.mybatisplus.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Gjing
 **/
@Service
public class EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * 添加员工
     * @param employeeDTO 员工传输对象
     */
    public void saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.findByName(employeeDTO.getEmployeeName());
        if (employee != null) {
            throw new ServiceException("添加失败，该员工已存在");
        }
        employee = BeanUtils.copyProperties(employeeDTO, Employee.class);
        employeeMapper.insert(employee);
    }

    /**
     * 删除员工
     * @param id 员工id
     */
    public void deleteById(Long id) {
        int delete = employeeMapper.deleteById(id);
        if (delete < 1) {
            throw new ServiceException("删除失败，员工不存在");
        }
    }

    /**
     * 更新员工信息
     * @param employeeDTO 员工传输对象
     */
    public void updateById(EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.findById(employeeDTO.getId()).orElseThrow(() -> new ServiceException("更新失败，员工不存在"));
        BeanUtils.copyProperties(employeeDTO, employee);
        employeeMapper.updateById(employee);
    }

    /**
     * 分页动态查询
     * @param employeeName 员工姓名
     * @param companyId 公司id
     * @param deptId 部门id
     * @param page 分页对象
     * @return PageResult<List<EmployeeVO>>
     */
    public PageResult<List<EmployeeVO>> pageEmployee(String employeeName, Long companyId, Long deptId, Page<EmployeeVO> page) {
        IPage<EmployeeVO> employeePage = employeeMapper.pageEmployee(page, employeeName, companyId, deptId);
        return PageResult.of(employeePage.getRecords(), (int) employeePage.getPages(), (int) employeePage.getCurrent(),
                employeePage.getTotal(), (int) employeePage.getSize());
    }
}
