package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.dao.EmpMapper;
import com.kgc.entity.Emp;
import com.kgc.entity.EmpExample;
import com.kgc.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;


    public PageInfo<Emp> findAll(int page, int limit, Emp emp) {
        //limit就是pageSize
        PageHelper.startPage(page, limit);
        //此对象已经通过下面的判断条件获取了值，传递对象即相当于传递了条件值
        EmpExample empExample = new EmpExample();
        EmpExample.Criteria criteria = empExample.createCriteria();

        //增加查询条件（通过criteria获取getxxxx的值）
        if (emp.getDeptid() != null&&emp.getDeptid()!=-1) {
            criteria.andDeptidEqualTo(emp.getDeptid());
        }
        if (emp.getEname() != null) {
            criteria.andEnameLike("%" + emp.getEname() + "%");
        }

        List<Emp> list = empMapper.selectByExample(empExample);  //通过条件查询获取的list
        PageInfo<Emp> pageInfo = new PageInfo<Emp>(list);   //经过分页对条件查询结果list进行处理
        return pageInfo;
    }

    public void saveEmp(Emp emp) {
        emp.setDeptid(1);
        emp.setMgr(102);
        empMapper.insert(emp);
    }


    public void deleteEmp(int id) {
        empMapper.deleteByPrimaryKey(id);
    }

    public Emp findById(int id) {
        return empMapper.selectByPrimaryKey(id);
    }

    public void updateEmp(Emp emp) {
        empMapper.updateByPrimaryKeySelective(emp);
    }

    public void deletesEmp(int[] ids) {
        empMapper.deleteEmps(ids);
    }
}
