package practice013.Spinner;
public class Language {
	 
    private String code;
    private String name;
    private String greeting;
 
    public Language() {
 
    }
 
    public Language(String code, String name) {
        this.code = code;
        this.name = name;
    }
 
    public Language(String code, String name, String greeting) {
        this.code = code;
        this.name = name;
        this.greeting = greeting;
    }
 
    public String getCode() {
        return code;
    }
 
    public void setCode(String code) {
        this.code = code;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getGreeting() {
        return greeting;
    }
 
    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
 
    @Override
    public String toString() {
        return this.name;
    }
 
}