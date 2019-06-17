package com.ejserver.apps.ej.dao.extend;


import com.ejserver.apps.ej.bean.extend.AddressExtend;

import java.util.List;

/**
 * @author 李洋
 * @date 2019-06-13 20:43
 */
public interface AddressExtendMapper {
    /**
     * 查出所有的客户以及其地址信息
     * @return
     */
    List<AddressExtend> findAllAddressAndCustomer();
    

}
