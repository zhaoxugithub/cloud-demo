package com.atguigu.order.bean;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @TableName order_tbl
 */
@Accessors(chain = true)
@Data
public class OrderTbl implements Serializable {
    private Integer id;
    private String userId;
    private String commodityCode;
    private Integer count;
    private Integer money;
    @Serial
    private static final long serialVersionUID = 1L;
}