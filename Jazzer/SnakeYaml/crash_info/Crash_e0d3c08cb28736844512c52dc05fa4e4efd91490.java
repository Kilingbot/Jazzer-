import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Crash_e0d3c08cb28736844512c52dc05fa4e4efd91490 {
    static final String base64Bytes = String.join("", "rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAABdwQAAAABdAACCkB4");

    public static void main(String[] args) throws Throwable {
        Crash_e0d3c08cb28736844512c52dc05fa4e4efd91490.class.getClassLoader().setDefaultAssertionStatus(true);
        try {
            Method fuzzerInitialize = SnakeYamlFuzzer.class.getMethod("fuzzerInitialize");
            fuzzerInitialize.invoke(null);
        } catch (NoSuchMethodException ignored) {
            try {
                Method fuzzerInitialize = SnakeYamlFuzzer.class.getMethod("fuzzerInitialize", String[].class);
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
        SnakeYamlFuzzer.fuzzerTestOneInput(input);
    }
}