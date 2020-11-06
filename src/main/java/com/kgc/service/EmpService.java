package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Emp;

public interface EmpService {
    PageInfo<Emp> findAll(int page, int limit, Emp emp);

    void saveEmp(Emp emp);

    void deleteEmp(int id);

    Emp findById(int id);

    void updateEmp(Emp emp);

    void deletesEmp(int[] ids);
}
