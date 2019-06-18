package com.ejserver.apps.ej.dao.extend;

import com.ejserver.apps.ej.bean.OrderLine;
import com.ejserver.apps.ej.bean.extend.OrderLineExtend;

import java.util.List;

/**
 * @author 李洋
 * @date 2019-06-13 20:43
 */
public interface OrderLineExtendMapper {
    List<OrderLineExtend> findExceptOrderLine();
    List<OrderLine> findOrderLinesByOrderId(Long id);
}
