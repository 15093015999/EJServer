package com.ejserver.apps.ej.web.controller;

import com.ejserver.apps.ej.bean.Address;
import com.ejserver.apps.ej.service.IAddressService;
import com.ejserver.apps.ej.utils.ActionResult;
import com.ejserver.apps.ej.utils.ActionResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 李洋
 * @date 2019/6/10
 */
@RestController
@RequestMapping("/address")
public class AddressController {
    @Resource
    private IAddressService addressService;


    @GetMapping("/selectByExample")
    public ActionResult selectByExample() {
        List<Address> addresses = addressService.selectByExample();
        return ActionResultUtil.success("查询成功！", addresses);
    }

    @GetMapping("/selectByPrimaryKey")
    public ActionResult selectByPrimaryKey(Long id) {
        Address address = addressService.selectByPrimaryKey(id);
        if (address == null) {
            return ActionResultUtil.error("查询用户不存在");
        }
        return ActionResultUtil.success("查询用户成功", address);
    }

    @PostMapping("/insert")
    public ActionResult insert(Address address) {
        int insert = addressService.insert(address);
        return insert == 1 ? ActionResultUtil.success("插入成功！") : ActionResultUtil.error("插入失败!");
    }

    @PostMapping("/deleteByPrimaryKey")
    public ActionResult deleteByPrimaryKey(Long id) {
        int delete = addressService.deleteByPrimaryKey(id);
        return delete == 1 ? ActionResultUtil.success("删除成功！") : ActionResultUtil.error("删除失败!");
    }

    @PostMapping("/updateByPrimaryKey")
    public ActionResult updateByPrimaryKey(Address address) {
        int update = addressService.updateByPrimaryKey(address);
        return update == 1 ? ActionResultUtil.success("更新成功！") : ActionResultUtil.error("更新失败!");
    }

}
