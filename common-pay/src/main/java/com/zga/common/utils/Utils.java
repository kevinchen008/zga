package com.zga.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * Created by mikehuang on 2017/4/12.
 */
public final class Utils {

    // 以元为单位转成String
    public static String intToStringByYuan(Integer val) {

        return String.valueOf(intToDoubleByYuan(val));
    }

    // 以分为单位的int转成以元为单位的double
    public static Double intToDoubleByYuan(Integer val) {
        Double valD = new Double(val);
        return valD/100;
    }

    // 以分为单位转成String
    public static String doubleYuanToStringFen(Double val) {
        return String.valueOf(doubleYuanToIntFen(val));
    }

    // 以元为单位的double装成以分为单位的int
    public static Integer doubleYuanToIntFen(Double val) {
        val = val * 100;
        return val.intValue();
    }

    public static Integer stingYuanToIntFen(String val) {
        Double yuan = Double.parseDouble(val);

        return doubleYuanToIntFen(yuan);
    }

    public static String pairToJson(String name, String value) {
        return "[{\"" + name + "\":\"" + value + "\"}]";
    }



    public static String mapToJson(Map<String, String> map) {
        ObjectMapper mapper = new ObjectMapper();
        String  json="";
        try {
            json = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }


    /**
     * 当前时间加mins分钟
     * @param mins
     * @return
     */
    public static Date plusDateInMin(int mins) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MINUTE, mins);
        return c.getTime();
    }

    public static void main(String[] args) {
     /*   StringPair pair = new StringPair("a", "b");
        StringPair pair2 = new StringPair("c", "d");
        List<StringPair> pairList = new ArrayList<>();
        pairList.add(pair);pairList.add(pair2);*/
        System.out.println(DateUtils.formatDate(new Date(),"YYYYMMDDhhmmss"));
    }
}
