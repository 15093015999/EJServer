package com.ejserver.apps.ej.dao;

import com.ejserver.apps.ej.bean.Customer;
import com.ejserver.apps.ej.bean.CustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_customer
     *
     * @mbg.generated Sun Jun 16 20:50:30 CST 2019
     */
    long countByExample(CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_customer
     *
     * @mbg.generated Sun Jun 16 20:50:30 CST 2019
     */
    int deleteByExample(CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_customer
     *
     * @mbg.generated Sun Jun 16 20:50:30 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_customer
     *
     * @mbg.generated Sun Jun 16 20:50:30 CST 2019
     */
    int insert(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_customer
     *
     * @mbg.generated Sun Jun 16 20:50:30 CST 2019
     */
    int insertSelective(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_customer
     *
     * @mbg.generated Sun Jun 16 20:50:30 CST 2019
     */
    List<Customer> selectByExample(CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_customer
     *
     * @mbg.generated Sun Jun 16 20:50:30 CST 2019
     */
    Customer selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_customer
     *
     * @mbg.generated Sun Jun 16 20:50:30 CST 2019
     */
    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_customer
     *
     * @mbg.generated Sun Jun 16 20:50:30 CST 2019
     */
    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_customer
     *
     * @mbg.generated Sun Jun 16 20:50:30 CST 2019
     */
    int updateByPrimaryKeySelective(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ej_customer
     *
     * @mbg.generated Sun Jun 16 20:50:30 CST 2019
     */
    int updateByPrimaryKey(Customer record);
}