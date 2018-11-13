import okhttp3.*;

import java.io.IOException;

/**
 * Created by anna on 9/4/18.
 *
 */
public class SwOTA_LoginResAgent {


     public static void main (String [] args) throws IOException {



String url_LOgin = "http://apps-main-web01.vcs-external.versonix.com:8290/ota/oauth/token?username=VX_IRINAK&password=nav&client_id=ota&client_secret=ota&grant_type=password&scope=resagent";

          OkHttpClient client = new OkHttpClient();

        //  MediaType mediaType = MediaType.parse("");
         RequestBody  body = RequestBody.create(null, "");

          Request request = new Request.Builder()

        .url(url_LOgin)
                  .post(body)
                  .addHeader("content-type", "application/json")
            //      .addHeader("cache-control", "no-cache")
               //   .addHeader("postman-token", "d475bff9-40fb-e81a-2eef-2ee59021d727")
                  .build();



          Response response = client.newCall(request).execute();

          System.out.println(   response.body().string()
          );
     }


/**
 *
 * Request request = new Request.Builder()
 .url("http://apps-main-web01.vcs-external.versonix.com:8290/ota/oauth/token?username=VX_IRINAK&password=nav&client_id=ota&client_secret=ota&grant_type=password&scope=resagent")
 .post(null)
 .addHeader("content-type", "application/json")
 .addHeader("cache-control", "no-cache")
 .addHeader("postman-token", "2a574d3e-5714-f546-6d03-fe352ee100de")
 .build();

 Response response = client.newCall(request).execute();
 *


 System.out.println( "Test class is started");

 String otaUrl = "http://apps-main-web01.vcs-external.versonix.com:8290/ota";  // sw_Virgin_26

 String resAgent = "VX_IRINAK";
 String passw = "nav";
 String resAgentUrlTail = "&client_id=ota&client_secret=ota&grant_type=password&scope=resagent";
 String tokenUrl = "/oauth/token?username=" + resAgent + "&password=" + passw + resAgentUrlTail;

 //     String url_Login = "http://apps-main-web01.vcs-external.versonix.com:8290/ota/oauth/token?username=VX_IRINAK&password=nav&client_id=ota&client_secret=ota&grant_type=password&scope=resagent";

 String url_Login = otaUrl + tokenUrl;

 *
 *
 *
 * {
 "access_token": "29B385B6-12B6-4712-8989-332FE124ABA5",
 "token_type": "bearer",
 "refresh_token": "29B385B6-12B6-4712-8989-332FE124ABA5",
 "expires_in": 300,
 "scope": "resagent"
 }
 */



}
