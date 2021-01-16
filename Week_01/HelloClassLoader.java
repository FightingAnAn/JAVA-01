package jvm;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            Object obj = new HelloClassLoader().findClass("Hello").newInstance();
            if (obj != null) {
                Method method = obj.getClass().getMethod("hello");
                method.invoke(obj);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected Class<?> findClass(String name) {
        byte[] bytes = getFileBytes("D:\\workspace\\idea_space\\jvm\\src\\jvm\\Hello.xlass");
        if (bytes != null) {
            byte[] newBytes = new byte[bytes.length];
            for (int i = 0 ; i < bytes.length ; i++) {
                newBytes[i] = (byte) (255 - bytes[i]);
            }
            return defineClass(name, newBytes, 0 , newBytes.length);
        }
        return null;
    }

    private static byte[] getFileBytes(String fileName) {
        try {
            File f = new File(fileName);
            int length = (int) f.length();
            byte[] data = new byte[length];
            new FileInputStream(f).read(data);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
