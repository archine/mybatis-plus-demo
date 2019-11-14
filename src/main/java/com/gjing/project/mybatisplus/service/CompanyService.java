package com.gjing.project.mybatisplus.service;

import cn.gjing.tools.common.result.PageResult;
import cn.gjing.tools.common.util.ParamUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gjing.project.mybatisplus.domain.entity.Company;
import com.gjing.project.mybatisplus.exception.ServiceException;
import com.gjing.project.mybatisplus.mapper.CompanyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Gjing
 **/
@Service
public class CompanyService {
    @Resource
    private CompanyMapper companyMapper;

    /**
     * 添加公司
     * @param companyName 公司名称
     */
    public void saveCompany(String companyName) {
        Company company = companyMapper.findByName(companyName);
        if (company != null) {
            throw new ServiceException("添加失败，该公司已存在");
        }
        company = Company.builder()
                .companyName(companyName)
                .build();
        companyMapper.insert(company);
    }

    /**
     * 删除公司
     * @param companyId 公司id
     */
    public void deleteCompany(Long companyId) {
        int delete = companyMapper.deleteById(companyId);
        if (delete < 1) {
            throw new ServiceException("删除失败，公司不存在");
        }
    }

    /**
     * 更新公司名称
     * @param companyId 公司id
     * @param companyName 公司名
     */
    public void updateCompany(Long companyId, String companyName) {
        Company company = companyMapper.findById(companyId).orElseThrow(() -> new ServiceException("修改失败，公司不存在"));
        company.setCompanyName(companyName);
        companyMapper.updateById(company);
    }

    /**
     * 动态分页查询公司列表------------>适合单表
     *
     * @param companyName 公司名称
     * @return PageResult<List<Company>>
     */
    public PageResult<List<Company>> pageCompany(String companyName, Page<Company> page) {
        QueryWrapper<Company> queryWrapper = new QueryWrapper<>();
        if (ParamUtils.isNotEmpty(companyName)) {
            queryWrapper.eq("company_name", companyName);
        }
        queryWrapper.orderByDesc("id");
        IPage<Company> iPage = companyMapper.selectPage(page, queryWrapper);
        return PageResult.of(iPage.getRecords(), (int) iPage.getPages(), (int) iPage.getCurrent(),
                iPage.getTotal(), (int) iPage.getSize());
    }
}
