package com.bdqn.crm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringsUtil {

    /**
     * 根据身份证号输出年龄
     * @param IdNO
     * @return
     */
    public static int idNOToAge(String IdNO){
        int leh = IdNO.length();
        String dates="";
        if (leh == 18) {
            int se = Integer.valueOf(IdNO.substring(leh - 1)) % 2;
            dates = IdNO.substring(6, 10);
            SimpleDateFormat df = new SimpleDateFormat("yyyy");
            String year=df.format(new Date());
            int u=Integer.parseInt(year)-Integer.parseInt(dates);
            return u;
        }else{
            dates = IdNO.substring(6, 8);
            return Integer.parseInt(dates);
        }

    }

}
