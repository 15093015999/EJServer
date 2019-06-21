package com.ejserver.apps.ej.dao.extend;

import com.ejserver.apps.ej.bean.VM.OrderVM;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderExtendMapper {
    List<OrderVM> queryBasic(
            @Param("customerId") Long customerId,
            @Param("waiterId")Long  waiterId
    );
}
