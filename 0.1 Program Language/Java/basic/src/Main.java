import java.util.HashMap;
import java.util.Map;

public class Main {
  // psvm + 텝 !!
  public static void main(String[] args) {
    
    Map<String, String> map = new HashMap<String, String>();
    map.put("people", "사람");
    map.put("baseball", "야구");

    System.out.println(map.get("people"));
    System.out.println(map.containsKey("people"));
    System.out.println(map.size());
    System.out.println(map.keySet());  // [baseball, people] 출력
    System.out.println(map.remove("people"));
  }
}
