package TestDatalari;

import org.json.JSONObject;

public class TestDataJsonPlaceholder {

    public static int basariliSorguStatusCode=200;

    public static JSONObject responseBodyOlustur22(){

        JSONObject expectedData= new JSONObject();
        expectedData.put("userId",3);
        expectedData.put("id",22);
        expectedData.put("title","dolor sint quo a velit explicabo quia nam");
        expectedData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return expectedData;
    }
}
