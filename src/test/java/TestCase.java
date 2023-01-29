import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import org.example.Players;
import org.example.Team;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase {

    String json = "{\n" +
            "  \"name\": \"Royal Challengers Bangalore\",\n" +
            "  \"location\": \"Bangalore\",\n" +
            "  \"player\": [\n" +
            "    {\n" +
            "      \"name\": \"Faf Du Plessis\",\n" +
            "      \"country\": \"South Africa\",\n" +
            "      \"role\": \"Batsman\",\n" +
            "      \"price-in-crores\": \"7\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Virat Kohli\",\n" +
            "      \"country\": \"India\",\n" +
            "      \"role\": \"Batsman\",\n" +
            "      \"price-in-crores\": \"15\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Glenn Maxwell\",\n" +
            "      \"country\": \"Australia\",\n" +
            "      \"role\": \"Batsman\",\n" +
            "      \"price-in-crores\": \"11\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Mohammad Siraj\",\n" +
            "      \"country\": \"India\",\n" +
            "      \"role\": \"Bowler\",\n" +
            "      \"price-in-crores\": \"7\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Harshal Patel\",\n" +
            "      \"country\": \"India\",\n" +
            "      \"role\": \"Bowler\",\n" +
            "      \"price-in-crores\": \"10.75\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Wanindu Hasaranga\",\n" +
            "      \"country\": \"Srilanka\",\n" +
            "      \"role\": \"Bowler\",\n" +
            "      \"price-in-crores\": \"10.75\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Dinesh Karthik\",\n" +
            "      \"country\": \"India\",\n" +
            "      \"role\": \"Wicket-keeper\",\n" +
            "      \"price-in-crores\": \"5.5\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Shahbaz Ahmed\",\n" +
            "      \"country\": \"India\",\n" +
            "      \"role\": \"All-Rounder\",\n" +
            "      \"price-in-crores\": \"2.4\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Rajat Patidar\",\n" +
            "      \"country\": \"India\",\n" +
            "      \"role\": \"Batsman\",\n" +
            "      \"price-in-crores\": \"0.20\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Josh Hazlewood\",\n" +
            "      \"country\": \"Australia\",\n" +
            "      \"role\": \"Bowler\",\n" +
            "      \"price-in-crores\": \"7.75\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\": \"Mahipal Lomror\",\n" +
            "      \"country\": \"India\",\n" +
            "      \"role\": \"Bowler\",\n" +
            "      \"price-in-crores\": \"7.75\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public Team body;
    @BeforeTest
    public void setUp()
    {
        Gson gson = new Gson();

        body = gson.fromJson(json, Team.class);
    }

    @Test
    public void validatePlayers()
    {
        int count = 0 ;
        int size = body.getPlayer().size();
        String str = "India";

       for(int i=0; i<size; i++)
       {
           if(!(str.equals(body.getPlayer().get(i).getCountry())))
           {
               count++;
           }
       }
        Assert.assertEquals(count,4,"Team has more than 4 foreign players");
    }

    @Test
    public void testWicketKeeper()
    {
        int count = 0 ;
        int size = body.getPlayer().size();
        String str = "Wicket-keeper";

        for(int i=0; i<size; i++)
        {
            if(!(str.equals(body.getPlayer().get(i).getRole())))
            {
                count++;
                break;
            }
        }
        Assert.assertEquals(count,1,"There is not atleast one Wicket keeper");
    }
}
