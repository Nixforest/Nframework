/**
 * Copyright (C) Nixforest System Development Co., Ltd. 2016. All rights reserved.
 */
package nixforest.cpn.nframework.commons.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import nixforest.cpn.nframework.commons.exception.GenericRuntimeException;


/**
 * @author Nixforest
 * @date Mar 01, 2016
 */
public final class ReflectUtil {
    private ReflectUtil() {
    }
    public static Object getInst(String clsNm) {
        //TODO-AssertUtil.assertNotNull(clsNm);

        Object obj = null;
        try {
            obj = Class.forName(clsNm).newInstance();

        } catch( ClassNotFoundException e ) {
            throw new GenericRuntimeException(e);
        } catch( InstantiationException e ) {
            throw new GenericRuntimeException(e);
        } catch( IllegalAccessException e ) {
            throw new GenericRuntimeException(e);
        }
        return obj;
    }
    public static Object getInst(Class<?> cls) {
        //TODO-AssertUtil.assertNotNull(cls);

        Object obj = null;
        try {
            obj = cls.newInstance();

        } catch( InstantiationException e ) {
            throw new GenericRuntimeException(e);
        } catch( IllegalAccessException e ) {
            throw new GenericRuntimeException(e);
        }
        return obj;
    }
    public static boolean hasMethod(Object obj, String methodName, Class<?>[] clsArray) {
        //TODO-AssertUtil.assertNotNull(obj);
        //TODO-AssertUtil.assertNotEmpty(methodName);

        boolean ret = false;
        try {
            obj.getClass().getMethod(methodName, clsArray);
            ret = true;
        } catch (SecurityException e) {
            ret = false;
        } catch (NoSuchMethodException e) {
            ret = false;
        }
        return ret;
    }
    public static Object invokeMethod(Object obj,
            String methodName,
            Class<?>[] clsArray,
            Object[] paramArray) {
        //TODO-AssertUtil.assertNotNull(obj);
        //TODO-AssertUtil.assertNotEmpty(methodName);
        
        Method method = null;
        try {
            method = obj.getClass().getMethod(methodName, clsArray);
        } catch (SecurityException e) {
            throw new GenericRuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new GenericRuntimeException(e);
        }
        
        Object ret = null;
        try {
            ret = method.invoke(obj, paramArray);
        } catch (IllegalArgumentException e) {
            throw new GenericRuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new GenericRuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new GenericRuntimeException(e);
        }
        return ret;
    }
    public static Class<?> getClass(String clazz) {
        //TODO-AssertUtil.assertNotNull(clazz);
        Class<?> cls = null;
        try {
           cls = Class.forName(clazz);
        } catch (ClassNotFoundException e) {
            throw new GenericRuntimeException(e);
        }
        return cls;
    }
}
