package com.ejserver.apps.ej.service.Impl;

import com.ejserver.apps.ej.bean.Waiter;
import com.ejserver.apps.ej.bean.WaiterExample;
import com.ejserver.apps.ej.dao.WaiterMapper;
import com.ejserver.apps.ej.service.IWaiterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 黄洋洋
 * WaiterServiceImpl
 */
@Service
public class WaiterServiceImpl implements IWaiterService {
    @Resource
    private WaiterMapper waiterMapper;

    @Override
    public List<Waiter> findAll() {
        return waiterMapper.selectByExample(new WaiterExample());
    }

    @Override
    public int insert(Waiter record) {
        return waiterMapper.insert(record);
    }

    @Override
    public int deleteById(Long id) throws Exception {
        Waiter waiter = waiterMapper.selectByPrimaryKey(id);
        if (waiter == null){
            throw new Exception("要删除的工人不存在");
        }
        else {
            return waiterMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public int updateById(Waiter record) {
        return waiterMapper.updateByPrimaryKey(record);
    }

    @Override
    public Waiter findById(Long id) {
        return waiterMapper.selectByPrimaryKey(id);
    }
}
