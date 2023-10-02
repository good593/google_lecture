
public class Main {
  // psvm + 텝 !!
  public static void main(String[] args) {
    
    int month = 3;
    String monthString = "";
    switch (month) {  // 입력 변수의 자료형은 byte, short, char, int, enum, String만 가능하다.
        case 1:  monthString = "January";
                  break;
        case 2:  monthString = "February";
                  break;
        case 3:  monthString = "March";
                  break;
        default: monthString = "Invalid month";
                  break;
    }
    System.out.println(monthString);
  }
}
