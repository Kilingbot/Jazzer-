import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Crash_f372b69d7a252f2a6ac71f53631019c0d946f4da {
    static final String base64Bytes = String.join("", "rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAABdwQAAAABdAAHamF6emUKCng=");

    public static void main(String[] args) throws Throwable {
        Crash_f372b69d7a252f2a6ac71f53631019c0d946f4da.class.getClassLoader().setDefaultAssertionStatus(true);
        try {
            Method fuzzerInitialize = CommonsCollectionsFuzzer.class.getMethod("fuzzerInitialize");
            fuzzerInitialize.invoke(null);
        } catch (NoSuchMethodException ignored) {
            try {
                Method fuzzerInitialize = CommonsCollectionsFuzzer.class.getMethod("fuzzerInitialize", String[].class);
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
        CommonsCollectionsFuzzer.fuzzerTestOneInput(input);
    }
}