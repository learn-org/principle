package com.learn.reflect;

import com.learn.entity.ReflectApple;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: lxj
 * @Date: 2021/2/5
 * @Description:
 */

public class ReflectLearn {

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ReflectApple reflectApple = new ReflectApple();
        reflectApple.setColor("green");
        reflectApple.setColor("big");
        Class reflectAppleClass = reflectApple.getClass();
        Class reflectAppleClasses = new ReflectApple().getClass();
        Object[] objects = reflectAppleClass.getEnumConstants();
        Field field = reflectAppleClass.getDeclaredField("color");
        // 设置为true，才可访问私有属性
        field.setAccessible(Boolean.TRUE);
        // 设置属性值
        field.set(reflectApple, "red");
        // 获取属性值
        Object object = field.get(reflectApple);
        System.out.println("color:" + object);
        Field[] fields = reflectAppleClass.getDeclaredFields();
        Method[] methods = reflectAppleClass.getDeclaredMethods();
        Method method = reflectAppleClass.getMethod("getColor");
        Object o = method.invoke(reflectApple);
        System.out.println(o);
        Method m = reflectAppleClass.getMethod("setColor", String.class);
        Object so = m.invoke(reflectApple, "small");
        System.out.println(so);
        System.out.println(method.invoke(reflectApple));
        Long l = 10L* 365L * 24L * 60L * 60L * 1000L;
        System.out.println(l);
        String sss = "org.apache.catalina.connector.ClientAbortException: java.io.IOException: Connection reset by peer\n" +
                "        at org.apache.catalina.connector.OutputBuffer.realWriteBytes(OutputBuffer.java:389)\n" +
                "        at org.apache.tomcat.util.buf.ByteChunk.flushBuffer(ByteChunk.java:426)\n" +
                "        at org.apache.catalina.connector.OutputBuffer.doFlush(OutputBuffer.java:338)\n" +
                "        at org.apache.catalina.connector.OutputBuffer.flush(OutputBuffer.java:313)\n" +
                "        at org.apache.catalina.connector.CoyoteOutputStream.flush(CoyoteOutputStream.java:110)\n" +
                "        at java.io.BufferedOutputStream.flush(BufferedOutputStream.java:141)\n" +
                "        at com.agrant.oa.saas.api.contoller.FileController.downFile(FileController.java:207)\n" +
                "        at com.agrant.oa.saas.api.contoller.FileController$$FastClassBySpringCGLIB$$77d89c8.invoke(<generated>)\n" +
                "        at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:204)\n" +
                "        at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:669)\n" +
                "        at com.agrant.oa.saas.api.contoller.FileController$$EnhancerBySpringCGLIB$$7a1ad39b.downFile(<generated>)\n" +
                "        at com.agrant.oa.saas.api.contoller.FileController$$FastClassBySpringCGLIB$$77d89c8.invoke(<generated>)\n" +
                "        at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:204)\n" +
                "        at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:669)\n" +
                "        at com.agrant.oa.saas.api.contoller.FileController$$EnhancerBySpringCGLIB$$70dfecf8.downFile(<generated>)\n" +
                "        at sun.reflect.GeneratedMethodAccessor562.invoke(Unknown Source)\n" +
                "        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n" +
                "        at java.lang.reflect.Method.invoke(Method.java:483)\n" +
                "        at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:205)\n" +
                "        at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:133)\n" +
                "        at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:97)\n" +
                "        at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:827)\n" +
                "        at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:738)\n" +
                "        at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:85)\n" +
                "        at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:967)\n" +
                "        at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:901)\n" +
                "        at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:970)\n" +
                "        at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:861)\n" +
                "        at javax.servlet.http.HttpServlet.service(HttpServlet.java:618)\n" +
                "        at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:846)";
        System.out.println(sss.indexOf(":"));
        System.out.println(sss.substring(0, sss.indexOf(" at ")));
    }
}
