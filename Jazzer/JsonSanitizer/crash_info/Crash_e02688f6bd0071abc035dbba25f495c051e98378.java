import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Crash_e02688f6bd0071abc035dbba25f495c051e98378 {
    static final String base64Bytes = String.join("", "rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAABdwQAAAABdAAfJ8CAwIDAgMCAwIDAgMCAwIDAgMCAFVwuIl1dXF1cPng=");

    public static void main(String[] args) throws Throwable {
        Crash_e02688f6bd0071abc035dbba25f495c051e98378.class.getClassLoader().setDefaultAssertionStatus(true);
        try {
            Method fuzzerInitialize = JsonSanitizerDenylistFuzzer.class.getMethod("fuzzerInitialize");
            fuzzerInitialize.invoke(null);
        } catch (NoSuchMethodException ignored) {
            try {
                Method fuzzerInitialize = JsonSanitizerDenylistFuzzer.class.getMethod("fuzzerInitialize", String[].class);
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
        JsonSanitizerDenylistFuzzer.fuzzerTestOneInput(input);
    }
}