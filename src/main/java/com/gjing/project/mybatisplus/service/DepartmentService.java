package com.gjing.project.mybatisplus.service;

import cn.gjing.tools.common.result.PageResult;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gjing.project.mybatisplus.domain.entity.Department;
import com.gjing.project.mybatisplus.domain.vo.DepartmentVO;
import com.gjing.project.mybatisplus.exception.ServiceException;
import com.gjing.project.mybatisplus.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Gjing
 **/
@Service
public class DepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;

    /**
     * 添加部门
     *
     * @param companyId 公司ID
     * @param deptName  部门名称
     */
    public void saveDepartment(Long companyId, String deptName) {
        Department department = departmentMapper.findByName(deptName);
        if (department != null) {
            throw new ServiceException("添加失败，部门已存在");
        }
        department = Department.builder()
                .deptName(deptName)
                .companyId(companyId)
                .build();
        departmentMapper.insert(department);
    }

    /**
     * 删除部门
     *
     * @param id 部门Id
     */
    public void deleteDepartment(Long id) {
        int delete = departmentMapper.deleteById(id);
        if (delete < 1) {
            throw new ServiceException("删除失败，部门不存在");
        }
    }

    /**
     * 更新部门
     *
     * @param id       部门id
     * @param deptName 部门名
     */
    public void updateDepartment(Long id, String deptName) {
        Department department = departmentMapper.selectById(id);
        if (department == null) {
            throw new ServiceException("更新失败，部门不存在");
        }
        department.setDeptName(deptName);
        departmentMapper.updateById(department);
    }

    /**
     * 分页查询部门列表-------------> 动态分页多表查询
     * @param page 分页对象
     * @param companyId 公司id
     * @param deptName 部门名称
     * @return PageResult<List<DepartmentVO>>
     */
    public PageResult<List<DepartmentVO>> pageDept(Page<DepartmentVO> page, Long companyId, String deptName) {
        IPage<DepartmentVO> departmentPage = departmentMapper.findPage(page, companyId, deptName);
        return PageResult.of(departmentPage.getRecords(), (int) departmentPage.getPages(), (int) departmentPage.getCurrent(),
                departmentPage.getTotal(), (int) departmentPage.getSize());
    }
}
