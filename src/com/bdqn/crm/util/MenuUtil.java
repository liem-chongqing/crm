package com.bdqn.crm.util;

import com.alibaba.fastjson.JSON;
import com.bdqn.crm.dto.MenuModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * 菜单组装
 */
public class MenuUtil {

    public static final String SYS_MENU = "sys_menu.json";
    public static final String BASE_MENU = "base_menu.json";

    public static List<MenuModel> getSysMenu(String menuType)  {
        InputStream inStream = MenuUtil.class.getClassLoader().getResourceAsStream(menuType);
        try {
            String jsonStr = inputStream2String(inStream);
            return JSON.parseArray(jsonStr,MenuModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    private static String inputStream2String(InputStream is) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        StringBuffer buffer = new StringBuffer();
        String line = "";
        while ((line = in.readLine()) != null){
            buffer.append(line);
        }
        return buffer.toString();
    }
}
