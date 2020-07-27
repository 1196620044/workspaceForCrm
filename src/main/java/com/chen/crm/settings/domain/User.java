package com.chen.crm.settings.domain;

/**
 * @Author: 86176
 * @Date: 2020/7/25 21:23
 * @Description:
 */
public class User {

    /*
     关于字符串中表现得日期及时间
     我们在市场上常用得有两种方式
     日期：年月日
        yyyy-MM-dd 十位字符串
     日期+时间
        yyyy-MM-dd HH:mm:ss 十九位字符串

    */

    /*
        关于登录
            验证账号和密码
            User user = 执行sql语句：select * from tbl_user where loginAct=? and loginPwd=?

            user对象为null，说明账号密码正确

            如果uer对象不为空，说明账号密码正确
            需要继续向下验证
            从user中get到
                expireTime 验证失效时间
                lockState 验证锁定状态
                allowIps 验证浏览器ip地址是否有效
    */
    private String id;  //主键，编号
    private String loginAct;  //登录账号
    private String name;  //姓名
    private String loginPwd;  //登录密码
    private String email;  //邮箱
    private String expireTime;  //失效时间
    private String lockState;  //锁定状态 0：锁定  1：启动
    private String deptno;  //部门编号
    private String allowIps;  //允许访问得ip地址
    private String createTime;  //创建时间
    private String createBy;  //创建人
    private String editTime;  //修改时间
    private String editBy;  //修改人

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginAct() {
        return loginAct;
    }

    public void setLoginAct(String loginAct) {
        this.loginAct = loginAct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getLockState() {
        return lockState;
    }

    public void setLockState(String lockState) {
        this.lockState = lockState;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getAllowIps() {
        return allowIps;
    }

    public void setAllowIps(String allowIps) {
        this.allowIps = allowIps;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public String getEditBy() {
        return editBy;
    }

    public void setEditBy(String editBy) {
        this.editBy = editBy;
    }
}
