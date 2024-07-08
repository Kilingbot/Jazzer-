import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.code_intelligence.jazzer.api.FuzzedDataProvider;

public class GsonFuzzer {
  private static final Gson gson = new Gson();

  public static void fuzzerTestOneInput(FuzzedDataProvider data) {
    try {

      String jsonString = data.consumeRemainingAsString();
      

      Object obj = gson.fromJson(jsonString, Object.class);

      // MyCustomClass customObj = gson.fromJson(jsonString, MyCustomClass.class);
    } catch (JsonSyntaxException ignored) {
    }
  }
}