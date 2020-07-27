package com.chen.settings.test;

import com.chen.crm.utils.DateTimeUtil;
import com.chen.crm.utils.MD5Util;

import javax.sound.midi.Soundbank;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: 86176
 * @Date: 2020/7/25 22:41
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        //验证失效时间
        /*String expireTime = "2020-06-25 10:10:10";
*/
       //当前系统时间
      /*  String currentTime = DateTimeUtil.getSysTime();

        int count = expireTime.compareTo(currentTime);
        System.out.println(count);*/

     /* String lockState = "0";
      if ("0".equals(lockState)){
          System.out.println("账号已锁定！！！");
      }*/

     //浏览器端的ip地址
        /*String ip = "192.168.1.3";
        String allowIps = "192.168.1.1,192.168.1.2";
        if (allowIps.contains(ip)){
            System.out.println("有效IP地址，允许访问");
        }else {
            System.out.println("ip地址受限，请联系管理员");
        }*/

        String pwd = "123";
        String md5Pwd = MD5Util.getMD5(pwd);
        System.out.println(md5Pwd);


        System.out.println(MD5Util.getMD5("321"));
    }
}
