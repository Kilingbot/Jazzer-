import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Crash_a35077a93b180088463ecc1cdf83178d99a53a66 {
    static final String base64Bytes = String.join("", "rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAABdwQAAAABdAACKQp4");

    public static void main(String[] args) throws Throwable {
        Crash_a35077a93b180088463ecc1cdf83178d99a53a66.class.getClassLoader().setDefaultAssertionStatus(true);
        try {
            Method fuzzerInitialize = BatikTranscoderFuzzer.class.getMethod("fuzzerInitialize");
            fuzzerInitialize.invoke(null);
        } catch (NoSuchMethodException ignored) {
            try {
                Method fuzzerInitialize = BatikTranscoderFuzzer.class.getMethod("fuzzerInitialize", String[].class);
                fuzzerInitialize.invoke(null, (Object) args);
            } catch (NoSuchMethodException ignored1) {
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                System.exit(1);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            System.exit(1);
        }
        com.code_intelligence.jazzer.api.CannedFuzzedDataProvider input = new com.code_intelligence.jazzer.api.CannedFuzzedDataProvider(base64Bytes);
        BatikTranscoderFuzzer.fuzzerTestOneInput(input);
    }
}