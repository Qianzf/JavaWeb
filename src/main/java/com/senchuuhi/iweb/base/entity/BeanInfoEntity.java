package com.senchuuhi.iweb.base.entity;

/**
 * 一个Bean的信息集合
 */
public class BeanInfoEntity {

    /** 名称 **/
    private String beanName = "";

    /** 类型 **/
    private String beanType = "";

    /** 所在类 **/
    private String className = "";

    /** 执行方法 **/
    private String executedMethodName = "";

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanType() {
        return beanType;
    }

    public void setBeanType(String beanType) {
        this.beanType = beanType;
    }

    public String getExecutedMethodName() {
        return executedMethodName;
    }

    public void setExecutedMethodName(String executedMethodName) {
        this.executedMethodName = executedMethodName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
