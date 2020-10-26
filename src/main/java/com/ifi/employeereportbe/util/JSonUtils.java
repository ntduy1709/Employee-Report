package com.ifi.employeereportbe.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import netscape.javascript.JSObject;

public class JSonUtils {

    public static  String getChildOfJson(JsonObject object, String ... keys){
        JsonObject childObj = object;
        String txt = null;
        for (int i = 0; i < keys.length; i++) {
            String key = keys[i];
            if (i == keys.length - 1){
                JsonPrimitive jsonPrimitive = childObj.getAsJsonPrimitive(key);
                if (jsonPrimitive != null){
                    txt = childObj.getAsJsonPrimitive(key).getAsString();
                }
            }else {
                childObj = (JsonObject) childObj.get(key);
            }
        }
        return txt;
    }
}
