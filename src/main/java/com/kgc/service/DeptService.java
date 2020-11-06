package com.kgc.service;

import com.kgc.entity.Dept;
import com.kgc.entity.TreeNode;
import com.kgc.entity.TreeResult;

import java.util.List;

public interface DeptService {
    public List<Dept> findAll();

    public List<TreeNode> findDetps();

    public List<TreeResult> findTreeResult();
}
