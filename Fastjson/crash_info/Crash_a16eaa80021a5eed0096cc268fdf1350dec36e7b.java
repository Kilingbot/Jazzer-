import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Crash_a16eaa80021a5eed0096cc268fdf1350dec36e7b {
    static final String base64Bytes = String.join("", "rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAABdwQAAAABdAADLQo7eA==");

    public static void main(String[] args) throws Throwable {
        Crash_a16eaa80021a5eed0096cc268fdf1350dec36e7b.class.getClassLoader().setDefaultAssertionStatus(true);
        try {
            Method fuzzerInitialize = FastJsonFuzzer.class.getMethod("fuzzerInitialize");
            fuzzerInitialize.invoke(null);
        } catch (NoSuchMethodException ignored) {
            try {
                Method fuzzerInitialize = FastJsonFuzzer.class.getMethod("fuzzerInitialize", String[].class);
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
        FastJsonFuzzer.fuzzerTestOneInput(input);
    }
}