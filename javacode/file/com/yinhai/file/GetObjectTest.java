package com.yinhai.file;

import com.alibaba.fastjson.JSONObject;
import com.yinhai.yhoss.DcsClient;
import com.yinhai.yhoss.client.cloudmodel.GetObjectRequest;
import com.yinhai.yhoss.client.cloudmodel.OSObject;

/**
 * @description: 下载文件
 * @author: zhongkai
 * @version: 1.0
 * @date: 2020/4/8 4:28 下午
 **/
public class GetObjectTest {

    public static void main(String[] args) {
        /**创建Dcs客户端对象*/
        DcsClient client = new DcsClient("http://192.168.17.159:8081/dcs","YWNjZXNzLWRnMTU5MDY1MjUwOTU0NA==", "54eM_L-4dar3edi4cnofKIzt0JLoQgsr0L2iC9Z5");
        GetObjectRequest getObjectRequest = new GetObjectRequest("bucket-159","27da05ca54ba41b0997116ae11e794a4",null);
//        File file = new File("C:\\Users\\Administrator\\Desktop\\test.txt");
//        ObjectMetadata object = client.getObject(getObjectRequest,file);
        OSObject object = client.getObject(getObjectRequest);
        System.out.println(JSONObject.toJSONString(object));
    }
}
