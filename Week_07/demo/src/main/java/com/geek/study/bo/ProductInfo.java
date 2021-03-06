package com.geek.study.bo;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Copyright (C), 2021
 * FileName: ProductInfo
 * Author:   xzw
 * Date:     2021/3/5 21:45
 * Description:
 */
@Data
public class ProductInfo implements Serializable {

    private Long id;

    private String productId;

    private String productCode;

    private String productName;

    private String barCode;

    private Double price;

    private Integer pushStatus;

    private Integer auditStatus;

    private Date productionDate;

    private Integer shelfLife;

    private String descript;

    private Timestamp createTime;

    private Timestamp updateTime;


}
