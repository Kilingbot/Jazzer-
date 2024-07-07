import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Crash_bdb728427084426f9975324f6823d4ee7dca28e2 {
    static final String base64Bytes = String.join("", "/yH//zj////5AAAAPSz////5kwAhAAAsAABzJg==");

    public static void main(String[] args) throws Throwable {
        Crash_bdb728427084426f9975324f6823d4ee7dca28e2.class.getClassLoader().setDefaultAssertionStatus(true);
        try {
            Method fuzzerInitialize = GifImageParserFuzzer.class.getMethod("fuzzerInitialize");
            fuzzerInitialize.invoke(null);
        } catch (NoSuchMethodException ignored) {
            try {
                Method fuzzerInitialize = GifImageParserFuzzer.class.getMethod("fuzzerInitialize", String[].class);
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
        byte[] input = java.util.Base64.getDecoder().decode(base64Bytes);
        GifImageParserFuzzer.fuzzerTestOneInput(input);
    }
}