import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Crash_d25bf0298ce027177fb7673a077bc82883eda3d3 {
    static final String base64Bytes = String.join("", "rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAABdwQAAAABdAANIlx1XHQMXHQMXHR0XHg=");

    public static void main(String[] args) throws Throwable {
        Crash_d25bf0298ce027177fb7673a077bc82883eda3d3.class.getClassLoader().setDefaultAssertionStatus(true);
        try {
            Method fuzzerInitialize = GsonFuzzer.class.getMethod("fuzzerInitialize");
            fuzzerInitialize.invoke(null);
        } catch (NoSuchMethodException ignored) {
            try {
                Method fuzzerInitialize = GsonFuzzer.class.getMethod("fuzzerInitialize", String[].class);
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
        GsonFuzzer.fuzzerTestOneInput(input);
    }
}