package com.ejserver.apps.ej.service;


import com.ejserver.apps.ej.bean.Address;
import com.ejserver.apps.ej.dto.CustomerAndAddress;

import java.util.List;

/**
 * @author 李洋
 * @date 2019/06/10
 */
public interface IAddressService {
    /**
     * find all information from ej_address
     * @return List
     */
    List<Address> selectByExample();

    /**
     * select your want info from ej_address by primaryKey(id)
     * @param id the primaryKey
     * @return Address include your want
     */
    Address selectByPrimaryKey(Long id);

    /**
     * delete info from ej_address by primary key
     * @param id primary key
     * @throws Exception throws the Exception
     * @return int success return 1,error return 0
     */
    int deleteByPrimaryKey(Long id) throws Exception;

    /**
     * insert address info to ej_address
     * @param address the info you insert
     * @return int success return 1,error return 0
     * @throws Exception throws the Exception
     */
    int insert(Address address) throws Exception;

    /**
     * update ej_address by primary key(id)
     * @param address update info
     * @return int success return 1,error return 0
     * @throws Exception throws the Exception
     */
    int updateByPrimaryKey(Address address) throws Exception;

    /**
     * find Customer And Address info By CustomerId
     * @param id address's foreign key , customer's primary key
     * @return Address
     */
    List<Address> findAddressByCustomerId(Long id);

}
