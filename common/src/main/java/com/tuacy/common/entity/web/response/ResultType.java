package com.tuacy.common.entity.web.response;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/21 14:16.
 */
public enum ResultType {

    /**
     * 成功
     */
    SUCCESS(0, "SUCCESS"),
    /**
     * 参数不正确
     */
    REQUEST_PARA_ERROR(1, "Parameter Error"),
    /**
     * JSON 参数格式错误
     */
    JSON_PARA_EXCEPTION(2, "Json format error"),
    /**
     * 数据库操作失败
     */
    DB_OPERATE_ERROR(3, "Database operation failed"),
    /**
     * 用户未授权
     */
    USER_NO_AUTH(4, "No authority"),
    /**
     * 服务器忙
     */
    SYS_SO_BUSY(5, "Server busy"),
    /**
     * 用户未登录
     */
    USER_NO_LOGIN(6, "User not login"),
    /**
     * 其他错误（自定义提示内容）
     */
    OTHER_ERROR(7, "Other error"),
    /**
     * 当保存操作时需要进行再次确认
     */
    NEED_CONFIRM(8, "Need confirm");

    /**
     * 状态
     */
    private int value;
    /**
     * 描述
     */
    private String desc;

    /**
     * 构造函数
     *
     * @param value 状态
     * @param desc  描述
     */
    ResultType(int value, String desc) {
        this.setValue(value);
        this.setDesc(desc);
    }

    /**
     * int到enum的转换函数
     *
     * @param value 状态
     * @return 返回类型
     */
    public static ResultType valueOf(int value) {
        switch (value) {
            case 0:
                return SUCCESS;
            case 1:
                return REQUEST_PARA_ERROR;
            case 2:
                return JSON_PARA_EXCEPTION;
            case 3:
                return DB_OPERATE_ERROR;
            case 4:
                return USER_NO_AUTH;
            case 5:
                return SYS_SO_BUSY;
            case 6:
                return USER_NO_LOGIN;
            case 7:
                return OTHER_ERROR;
            default:
                return null;
        }
    }

    /**
     * 错误代号
     */
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * 描述
     */
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
