import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Crash_9af1f400450668cede6b3a60faf88c71584799dd {
    static final String base64Bytes = String.join("", "rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAABdwQAAAABdABbL2V0YyYuLy4uL3IuLy8uLi8HYyguLi8uLi8vLi4vLi4vci4vLy4uLy9ldGMmLi8uLi9yLi8vLi4vB2MoLi4vLi4vLy4uLy4uL3IuLy8uLi8vZXRjL3Bhc3N3ZHg=");

    public static void main(String[] args) throws Throwable {
        Crash_9af1f400450668cede6b3a60faf88c71584799dd.class.getClassLoader().setDefaultAssertionStatus(true);
        try {
            Method fuzzerInitialize = fuzz.Main.class.getMethod("fuzzerInitialize");
            fuzzerInitialize.invoke(null);
        } catch (NoSuchMethodException ignored) {
            try {
                Method fuzzerInitialize = fuzz.Main.class.getMethod("fuzzerInitialize", String[].class);
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
        fuzz.Main.fuzzerTestOneInput(input);
    }
}