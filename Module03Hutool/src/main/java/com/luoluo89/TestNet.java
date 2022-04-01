package com.luoluo89;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
 
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import cn.hutool.core.net.NetUtil;
import org.junit.Test;
 
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
 
public class TestNet {
 
    @Test
    @Comment("ipv4 和 long 互换")
    public void test1(){
        String ip = "220.181.57.216";
        long value = 0L;
         
        value = NetUtil.ipv4ToLong(ip);
        ip = NetUtil.longToIpv4(value);
        p2("ip地址",ip, "对应的long", value);
        p2("long值 ",value, "对应的ip", ip);
         
    }  
     
    @Test
    @Comment("判断端口和地址")
    public void test2(){
        int port1 =80;
        int port2 =68000;
        String ip1 = "220.181.57.216";
        String ip2 = "192.168.0.8";
        p2("端口号",port1,  "是否已经被占用",!NetUtil.isUsableLocalPort(port1));
        p2("端口号",port2,  "是否一个有效的端口号",NetUtil.isValidPort(port2));
        p2("ip地址",ip1,  "是否是个内网地址",NetUtil.isInnerIP(ip1));
        p2("ip地址",ip2,  "是否是个内网地址",NetUtil.isInnerIP(ip2));
    }  
     
    @Test
    @Comment("其他相关操作")
    public void test3(){
         
        String ip = "220.181.57.216";
        String host = "how2j.cn";
         
        p2("原ip",ip,"隐藏最后一位",NetUtil.hideIpPart(ip));
        p2("域名",host,"对应的ip地址",NetUtil.getIpByHost(host));
        p3("本机ip地址",NetUtil.localIpv4s());
        p3("本机mac地址",NetUtil.getLocalMacAddress());
         
    }
     
    private String preComment = null; 
    private void c(String msg) {
        System.out.printf("\t备注：%s%n",msg);
    }
    private void p1(String type1, Object value1, String type2, Object value2) {
        p(type1, value1, type2, value2, "format1");
    }
    private void p2(String type1, Object value1, String type2, Object value2) {
        p(type1, value1, type2, value2, "format2");
    }
    private void p3(String type1, Object value1) {
        p(type1, value1, "", "", "format3");
    }
  
    private void p(String type1, Object value1, String type2, Object value2, String format) {
        try {
            throw new Exception();
        } catch (Exception e) {
              
            String methodName = getTestMethodName(e.getStackTrace());
            Method m =ReflectUtil.getMethod(this.getClass(), methodName);
            Comment annotation = m.getAnnotation(Comment.class);
            if(null!=annotation) {
                String comment= annotation.value();
                if(!comment.equals(preComment)) {
                    System.out.printf("%n%s 例子： %n%n",comment);
                    preComment = comment;
                }
                  
            }
        }
        int padLength = 12;
        type1=StrUtil.padAfter(type1,padLength,Convert.toSBC(" ").charAt(0));
        type2=StrUtil.padAfter(type2,padLength,Convert.toSBC(" ").charAt(0));
        if("format1".equals(format)) {
            System.out.printf("\t%s的:\t\"%s\" %n\t被转换为----->%n\t%s的 :\t\"%s\" %n%n",type1,value1, type2, value2);
        }
        if("format2".equals(format)) {
            System.out.printf("\t基于 %s:\t\"%s\" %n\t获取 %s:\t\"%s\"%n%n",type1,value1, type2, value2);
        }
        if("format3".equals(format)) {
            System.out.printf("\t%s:\t\"%s\" %n\t%n",type1,value1);
  
        }
    }
      
    private String getTestMethodName(StackTraceElement[] stackTrace) {
        for (StackTraceElement se : stackTrace) {
            String methodName = se.getMethodName();
            if(methodName.startsWith("test"))
                return methodName;
        }
        return null;
    }
  
    @Target({METHOD,TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @Documented
    public @interface Comment {
         String value();
    }
}