package com.adc.da.myutil.util;

import com.adc.da.util.utils.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IsEmpty {
    private boolean flag = true;
    private String className = "";
    public boolean IsValueEmpty(Object object) throws Exception {
        String className = IsWhatClass(object);
        System.out.println(className);
        switch (className){
            case "java.lang.Integer":
                 Integer intValue = (Integer) object;
                 if(intValue == null){
                     this.flag = false;
                 }
                break;
            case "java.lang.Character":
                 Character charValue = (Character) object;
                 if(charValue == null){
                     this.flag = false;
                 }
                break;
            case "java.lang.Long":
                 Long longValue = (Long) object;
                 if(longValue == null){
                     this.flag = false;
                 }
                break;
            case "java.lang.String":
                 String stringValue = (String) object;
                 if(stringValue == null){
                      this.flag = false;
                 }
                 break;
            case "java.util.ArrayList":
                List<Object> listValue = (List<Object>)object;
                if(listValue.size() == 0 || listValue == null){
                    this.flag = false;
                }
                break;
            case "java.util.HashMap":
                Map<Object,Object> mapValue = (Map<Object,Object>)object;
                if(mapValue.size() == 0 || mapValue == null){
                    this.flag = false;
                }
                break;
            default:
                Class<?> clazz=object.getClass();  //得到类对象
                Field[] fs=clazz.getDeclaredFields(); //得到属性集合
                List<String> list=new ArrayList<String>();
                for(Field field:fs){            //遍历属性
                    field.setAccessible(true); //设置属性是可以访问的（私有的也可以）
                    if(field.get(object)==null){
                        String name=field.getName();
                        list.add(name);
                    }
                }
                if(fs.length == list.size()){
                    this.flag = false;
                }
        }
        return this.flag;
    }



    public String IsWhatClass(Object object){

        this.className = object.getClass().getName();

        return this.className;
    }

}
