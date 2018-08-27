package com.iuiuu;

import com.iuiuu.utils.IdCardUtil;
import com.iuiuu.utils.StringUtil;

public class IdCardNoTest {
    public static void main(String[] args) throws Exception {
        String[] idCardNos = new String[]{
//                "42028119930318204X",
//                "440111199003082724",
//                "440111197311062785",
//                "362202197008010123",
//                "45092319971025408x",
//                "421087199306164220"
                "441581198810103074"
        };

        for (String idCardNo : idCardNos) {
//            System.out.println(IdCardUtil.verify(idCardNo));
//            System.out.println(IdCardUtil.getYear(idCardNo));
//            System.out.println(IdCardUtil.getMonth(idCardNo));
//            System.out.println(IdCardUtil.getDate(idCardNo));
//            System.out.println(IdCardUtil.getBirthday(idCardNo));
//            System.out.println(IdCardUtil.getCurrentAge(idCardNo));
//            System.out.println(IdCardUtil.getSex(idCardNo));
        }

        System.out.println(StringUtil.commonSuffix("fs1", "afs"));
        System.out.println(StringUtil.commonSuffix("aaafs1", "fdafs1"));
        System.out.println(StringUtil.trim("aeeeacb33eeea", new char[]{'a'}));
        System.out.println(StringUtil.trim("aeeeacb33eeea", new char[]{'a', 'e'}));
    }
}
