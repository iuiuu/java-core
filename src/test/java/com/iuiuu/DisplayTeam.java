package com.iuiuu;

import java.io.Serializable;
import java.util.List;

public class DisplayTeam implements Serializable {
    private int deptId;

    private String deptName;

    private List<TeamInfo> teamList;

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<TeamInfo> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<TeamInfo> teamList) {
        this.teamList = teamList;
    }

    public class TeamInfo {
        private int teamId;

        private String teamName;

        private String teamIntro;

        private List<DoctorInfo> doctorList;

        public int getTeamId() {
            return teamId;
        }

        public void setTeamId(int teamId) {
            this.teamId = teamId;
        }

        public String getTeamName() {
            return teamName;
        }

        public void setTeamName(String teamName) {
            this.teamName = teamName;
        }

        public String getTeamIntro() {
            return teamIntro;
        }

        public void setTeamIntro(String teamIntro) {
            this.teamIntro = teamIntro;
        }

        public List<DoctorInfo> getDoctorList() {
            return doctorList;
        }

        public void setDoctorList(List<DoctorInfo> doctorList) {
            this.doctorList = doctorList;
        }
    }

    /**
     * 医生信息
     */
    public class DoctorInfo {
        private int doctorId;

        private String doctorName;

        private String title;

        private String avatar;

        private String hospitalName;

        private String deptName;

        private String specialty;

        private String intro;

        private List<ScheduleInfo> scheduleList;

        public int getDoctorId() {
            return doctorId;
        }

        public void setDoctorId(int doctorId) {
            this.doctorId = doctorId;
        }

        public String getDoctorName() {
            return doctorName;
        }

        public void setDoctorName(String doctorName) {
            this.doctorName = doctorName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getHospitalName() {
            return hospitalName;
        }

        public void setHospitalName(String hospitalName) {
            this.hospitalName = hospitalName;
        }

        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public String getSpecialty() {
            return specialty;
        }

        public void setSpecialty(String specialty) {
            this.specialty = specialty;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public List<ScheduleInfo> getScheduleList() {
            return scheduleList;
        }

        public void setScheduleList(List<ScheduleInfo> scheduleList) {
            this.scheduleList = scheduleList;
        }
    }

    /**
     * 医生出诊时间
     */
    public class ScheduleInfo {
        private String week;

        private String date;

//        private String addr;

        private String afternoon;

        private String forenoon;

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

//        public String getAddr() {
//            return addr;
//        }
//
//        public void setAddr(String addr) {
//            this.addr = addr;
//        }


        public String getAfternoon() {
            return afternoon;
        }

        public void setAfternoon(String afternoon) {
            this.afternoon = afternoon;
        }

        public String getForenoon() {
            return forenoon;
        }

        public void setForenoon(String forenoon) {
            this.forenoon = forenoon;
        }
    }
}
