package timmax.java8.p0205;

public class TypeInference {
    public static void main(String[] args) {
        final Value<String> value = new Value<>();
        var a = value.getOrDefault("22", Value.defaultValue());
        System.out.println(a);
    }
}
