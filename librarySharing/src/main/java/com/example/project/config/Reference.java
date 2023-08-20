package com.example.project.config;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Reference {
    private static HashMap<Integer, String> categoryMap;

    public static long defaltBorrowTime = 1000 * 60 * 60 * 24 * 30;

    public Reference() {
        categoryMap.put(1, "马克思主义");
        categoryMap.put(2, "哲学");
        categoryMap.put(3, "社会科学总论");
        categoryMap.put(4, "政治法律");
        categoryMap.put(5, "军事");
        categoryMap.put(6, "经济");
        categoryMap.put(7, "文化");
        categoryMap.put(8, "语言");
        categoryMap.put(9, "文学");
        categoryMap.put(10, "艺术");
        categoryMap.put(11, "历史地理");
        categoryMap.put(12, "自然科学总论");
        categoryMap.put(13, "数理科学和化学");
        categoryMap.put(14, "天文学、地球科学");
        categoryMap.put(15, "生物科学");
        categoryMap.put(16, "医药、卫生");
        categoryMap.put(17, "农业科学");
        categoryMap.put(18, "工业技术");
        categoryMap.put(19, "交通运输");
        categoryMap.put(20, "航空、航天");
        categoryMap.put(21, "环境科学");
        categoryMap.put(22, "综合");
    }

    public static String getCategory(int key) {
        return categoryMap.get(key);
    }

    public static Date getDueDate(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.add(Calendar.DATE, 30);
        return calendar.getTime();
    }
}
