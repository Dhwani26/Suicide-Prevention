package com.example.ajay.suicide;

public class Detail {
        private String nos;
        private String name;

        Detail(String n,String s){
            nos=n;
            name=s;
        }
        public  String getNumber(){
            return nos;
        }

        public String getName(){
            return name;
        }
}
