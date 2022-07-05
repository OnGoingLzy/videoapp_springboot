package com.proj3.videoapp.controller;

public class test {
    public static void main(String[] args) {
        String test = "搞笑   日本 的";
        String sql = "select * from video where videoname like ";
        if(!test.isEmpty()){
            for(int i=0;i<test.length();i++){
                if(test.charAt(i) == ' ') continue;
                if(i==test.length()-1){
                    sql = sql + "'%" + test.charAt(i) + "%'";
                }else sql = sql +"'%" + test.charAt(i) + "%' or videoname like ";

            }
        }

        System.out.println(sql);
    }
}
