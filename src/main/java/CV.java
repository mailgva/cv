import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CV {
    static final String  FULL_NAME = "GORBATENKO VLADIMIR";
    static int           AGE       = 40;
    static final boolean SEX_MALE  = true;
    static final String  PHOTO_URL = "shorturl.at/blAFG";
    static final String  E_MAIL    = "mail.gva@gmail.com";
    static final String  PHONE     = "+380 95 708-14-09";
    static final String  ADDRESS   = "Ukraine, Odessa";
    static final String  LINKEDIN  = "https://www.linkedin.com/in/vladimir-gorbatenko/";
    static final String  GITHUB    = "https://github.com/mailgva";

    static final String  POSITION  = "Java Developer"; // MIDDLE.
    // Skills
    static       String  ENGLISH   = "Intermediate";

    static List<String> programmingLanguages = List.of(
                                     "Java (Core, Collections, Multithreading, JMX, Streams, Design Patterns)",
                                     "HTML", "CSS (Bootstrap)", "JavaScript (jQuery, ajax, other plugins)",
                                     "Delphi", "Visual FoxPro");

    static Map<String, String> frameworks   = Map.of(
                                 "Spring family", "Boot, Data JPA, MVC (REST), Security, Websocket, Profiles, "+
                                                          "i18n, Test, Some of *Spring Clouds*",
                                 "ORM", "Hibernate  (Transactions, Cachable)",
                                 "Build system","Maven");

    static Set<String> viewTemplates        = Set.of(
                                     "JSP (JSTL), Thymeleaf");

    static List<String> databases           = Stream.of(
                                     "MySQL", "PostgreSQL", "Firebird", "Oracle", "Sybase (ASE, ASA)",
                                     "H2", "HSQLDB", "Memcached",
                                     "MongoDB", "Neo4j", "Apache ZooKeeper", "Hazelcast")
                                      .collect(Collectors.toList());

    static List<String> otherSkills         = Arrays.asList(
                                     "Git", "Lombok", "JUnit (Hamcrest)", "SLF4J (LogBack)", "Ehcache",
                                     "Json Jackson", "Webjars", "JAX-RS", "JDBC", "Tomcat", "Jersey", "Servlets",
                                     "OAuth2", "JSON", "XML", "Docker", "Jenkins", "Heroku", "AWS");

    static Map<String, String> javaProjects = new HashMap<>(){{
                                 put("Calories management",
                                          "Spring (MVC, Data JPA, Security, Validation, Test), Hibernate, Tomcat, " +
                                                  "PostgreSQL, HSQLDB, i18n, " +
                                                  "REST, Webjars, JSP, jQuery, Bootstrap.\n" +
                                                  "Link: http://gva-caloriesmanagement.herokuapp.com,\n" +
                                                  "GitHub: https://github.com/mailgva/topjava15");
                                 put("Voting system",
                                         "Spring (Boot, Web, Data JPA (+@Async), Security (+OAuth2), Validation, Test), "+
                                                  "Hibernate, Lombok, Tomcat, PostgreSQL, H2, i18n, REST, Thymeleaf, " +
                                                  "Webjars, jQuery, Bootstrap, FileUpload.\n" +
                                                  "Link: https://gva-votingsystem-boot.herokuapp.com,\n" +
                                                  "GitHub: https://github.com/mailgva/votingsystem_h2_boot");
                                 put("Family budget",
                                          "Spring (Boot, Web, Data JPA, Security, Validation, Sheduler), MongoDB, " +
                                                  "GoogleDrive, Lombok, " +
                                                  "Thymeleaf, Webjars, jQuery, Bootstrap, Charts.\n" +
                                                  "Link: http://gvabudget.herokuapp.com,\n" +
                                                  "GitHub: https://github.com/mailgva/Budget");}};

    public static void main(String[] args) {
        printCV();
    }

    private static void printCV() {
        System.out.println(combineData());
    }

    private static String combineData() {
        int spaceOffset = 26;
        StringBuilder data = new StringBuilder();
        data.append(format("Full Name", FULL_NAME));
        data.append(format("Age", String.valueOf(AGE)));
        data.append(format("E-mail", E_MAIL));
        data.append(format("Phone", PHONE));
        data.append(format("Address", ADDRESS));
        data.append(format("LinkedIn", LINKEDIN));
        data.append(format("GitHub", GITHUB));
        data.append(format("Photo URL", PHOTO_URL));
        data.append("\n");
        data.append(format("Position", POSITION));
        data.append("\n");
        data.append("Skills\n");
        data.append("=".repeat(24) + "\n");
        data.append(format("English", ENGLISH));
        data.append(format("Programming Languages", String.join(", ", programmingLanguages)));
        data.append(format("Frameworks", "\n" + frameworks.entrySet().stream()
                .map(e -> String.format("%-" + spaceOffset + "s%s : %s", " ", e.getKey(), e.getValue()))
                .sorted(Comparator.comparing(String::valueOf).reversed())
                .collect(Collectors.joining("\n"))));
        data.append(format("View templates", String.join(", ", viewTemplates)));
        data.append(format("Databases", String.join(", ", databases)));
        data.append(format("Other", String.join(", ", otherSkills)));
        data.append("\n");
        data.append(format("Java projects", "\n" + javaProjects.entrySet().stream()
                .map(e -> String.format("%-" + spaceOffset + "s%s : %s", " ", e.getKey(), e.getValue().replace("\n", "\n" + " ".repeat(spaceOffset))) + "\n")
                .sorted(Comparator.comparing(String::valueOf))
                .collect(Collectors.joining("\n"))));
        return data.toString();
    }

    private static String format(String key, String value) {
        return String.format("%-24s: %s\n", key, value);
    }
}
