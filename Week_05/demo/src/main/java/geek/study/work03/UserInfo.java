package geek.study.work03;

import lombok.Data;

/**
 * Copyright (C), 2021
 * FileName: UserInfo
 * Author:   xzw
 * Date:     2021/2/20 23:48
 * Description:
 */
@Data
public class UserInfo {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 联系地址
     */
    private String address;
}
