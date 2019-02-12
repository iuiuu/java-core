package com.iuiuu;

import com.iuiuu.utils.Base64Util;
import com.iuiuu.utils.DateUtil;
import com.iuiuu.utils.JsonUtil;
import com.iuiuu.utils.RandomUtil;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class JsonUtilTest {

    public static void main(String[] args) throws Exception {
        int[] a = new int[]{1, 4, 23, 56, 65, 323};
        String json = JsonUtil.toJson(a);
        System.out.println(json);

        DisplayTeam team = new DisplayTeam();
        team.setDeptId(321);
        team.setDeptName("呼吸内科");
        team.setTeamList(null);

        json = JsonUtil.toJson(team);
        System.out.println(json);

        team = new DisplayTeam();
        team.setDeptId(321);
        team.setDeptName("呼吸内科");
        team.setTeamList(new LinkedList<DisplayTeam.TeamInfo>());

        json = JsonUtil.toJson(team);
        System.out.println(json);

        Object obj = null;
        System.out.println("hhh" + obj);

        String strDate = "20000229";
        String pattern = "yyyyMMdd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            sdf.setLenient(false);
            sdf.parse(strDate);
        } catch (Exception e) {
            e.printStackTrace();
        }


        Date date = DateUtil.stringToDate("19970230", "yyyyMMdd");
        System.out.println(date);

        for(int i = 0 ; i < 100; i++)
        System.out.println(RandomUtil.randInt(10));

        System.out.println(Base64Util.encode("ii".getBytes(StandardCharsets.UTF_8)));

    }
}
