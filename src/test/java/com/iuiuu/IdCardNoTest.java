package com.iuiuu;

import com.iuiuu.utils.IdCardUtil;

public class IdCardNoTest {
    public static void main(String[] args) throws Exception {
        String[] idCardNos = new String[]{
                "42028119930318204X",
                "440111199003082724",
                "440111197311062785",
                "362202197008010123",
                "45092319971025408x",
                "421087199306164220"
        };

        for (String idCardNo : idCardNos) {
            System.out.println(IdCardUtil.verify(idCardNo));
            System.out.println(IdCardUtil.getYear(idCardNo));
            System.out.println(IdCardUtil.getMonth(idCardNo));
            System.out.println(IdCardUtil.getDate(idCardNo));
        }
    }
}
