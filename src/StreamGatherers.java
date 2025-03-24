public class StreamGatherers {

    public static void main(String[] args) {
        java.util.List<String> names = java.util.Arrays.asList("Gremio", "Inter", "Caxias", "Juventude");

        // Using the stream gatherer to collect a Map with names as keys and lengths as values
        java.util.Map<String, Integer> nameLengths = names.stream()
                .collect(java.util.stream.Collectors.toMap(
                        name -> name,  // Key: name
                        String::length  // Value: length of name
                ));

        System.out.println(nameLengths);
    }
}
