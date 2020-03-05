package com.alicom.dysms.api;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
/*
pom.xml
<dependency>
  <groupId>com.aliyun</groupId>
  <artifactId>aliyun-java-sdk-core</artifactId>
  <version>4.4.6</version>
</dependency>
*/
public class QueryAPI {
    public static void main(String[] args) {
        // acsClient,<accessKeyId> and "<accessSecret>" can be get from the console
        DefaultProfile profile = DefaultProfile.getProfile("ap-southeast-1", "", "");
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        //Domain name, don’t change
        request.setDomain("sms-intl.ap-southeast-1.aliyuncs.com");
        //API version, don’t change
        request.setVersion("2018-05-01");
        //API name
        request.setAction("QueryMessage");
        request.putQueryParameter("MessageId", "190571583387857188");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}