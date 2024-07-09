import org.apache.commons.lang3.SerializationUtils;
import com.code_intelligence.jazzer.api.FuzzedDataProvider;

public class CommonsLangFuzzer {
    public static void fuzzerTestOneInput(FuzzedDataProvider data) {
        byte[] input = data.consumeBytes(100);
        try {
            SerializationUtils.deserialize(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}