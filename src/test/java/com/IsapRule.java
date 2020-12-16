package com;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;


/**
 * @Author:cai.chaoxiong
 * @Date: 2019/10/25 10:45
 */

public class IsapRule {

    @Test
    public void map(){
        List<FeedbackMsgRfsAttr> list = new ArrayList<>();
        FeedbackMsgRfsAttr attr = new FeedbackMsgRfsAttr();
        attr.setRfsId( "1" );
        attr.setAttrCode( "1" );
        list.add( attr );
        Map<String,FeedbackMsgRfsAttr> map = list.stream().collect( Collectors.toMap(FeedbackMsgRfsAttr::getAttrCode, attrs -> attrs));
        map.get( "1" ).setRfsId( "2" );
        System.out.println(JSON.toJSONString( list.get( 0 ) ));
    }

    @Test
    public void test1(){
        reverse(-123);
    }
    public int reverse(int x) {
        String result = "";
        String intString = String.valueOf(x);
        String[] ints = intString.split("");
        String perfix = "";
        if("-".equals(ints[0])){
            perfix = ints[0];
        }
        int end = perfix.equals("")?0:1;
        for (int i = ints.length - 1; i >= end; i--) {

            if(i==0 && "0".equals(ints[i])){

            }else {
                result+=   ints[i];
            }
        }
        return Integer.parseInt(perfix+result);
    }
    public class FeedbackMsgRfsAttr implements Serializable {

        private static final long serialVersionUID = 779233358940357853L;
        private String attrCode;
        private String value;
        private String rfsId;
        private String rfsCode;

        public String getAttrCode() {
            return attrCode;
        }

        public void setAttrCode(String attrCode) {
            this.attrCode = attrCode;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getRfsId() {
            return rfsId;
        }

        public void setRfsId(String rfsId) {
            this.rfsId = rfsId;
        }

        public String getRfsCode() {
            return rfsCode;
        }

        public void setRfsCode(String rfsCode) {
            this.rfsCode = rfsCode;
        }
    }
    @Test
    public void getOac_id(){
        List<String> cfsAttrList =null;
        JSON.toJSONString( cfsAttrList );
        String recvMsg = "{\n" +
                "\t\"uuid\": \"31886505-59c8-4864-8618-b209a6e4bb65\",\n" +
                "\t\"order_type\": \"oac_create\",\n" +
                "\t\"oac_id\": \"210002004\"" +
                "}";
        String oacId = "";
        if(!"".equals( recvMsg )){
            com.alibaba.fastjson.JSONObject obj = com.alibaba.fastjson.JSONObject.parseObject( recvMsg );
            oacId = obj.getString( "oac_id" );
        }
        if("".equals( oacId )){
            throw new NullPointerException( "oac_id cannot be empty" );
        }
        //return oacId;
        System.out.println(oacId);
    }



    /**
     * Save Internet 存在则返回1
     * @param saveInternet 规则参数
     * @return
     */
    public String saveInternet(String saveInternet){
        if(saveInternet == null || "".equals( saveInternet ) ){
            return "0";
        }
        return "1";
    }

    @Test
    public void test(){
        String phoneNumber = "1,2,4";
        if(!"".equals( phoneNumber )){
            String nums="\""+phoneNumber.replaceAll( ",","\",\"" )+"\"";
            System.out.println(nums);
        }
        //return "";
    }

    @Test
    public void test2(){
        String recvMsg = "";
        String barringProfileTemp = "ENUM:\n" +
                "NONE, \n" +
                "SOFT_SUSPENSION, \n" +
                "HARD_SUSPENSION, \n" +
                "INTERNATIONAL, \n" +
                "INTERNATIONAL_AND_MOBILE, \n" +
                "INTERNATIONAL_AND_MOBILE_AND_PREMIUM, \n" +
                "ROUTING_PREFIX, \n" +
                "MOBILE, \n" +
                "MOBILE_AND_PREMIUM, \n" +
                "PREMIUM_AND_EXOTIC, \n" +
                "PREMIUM, \n" +
                "INTERNATIONAL_EXCEPT_BE_DE_FR_NL, \n" +
                "CARRIER_DIALLING, \n" +
                "TOLL, \n" +
                "DIALER";
        if("0000:success".equals( recvMsg )){
            recvMsg = barringProfileTemp;
        }
       //return recvMsg;
    }
}
