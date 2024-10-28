package valdiaciones;

public class ValidationUtils {

  public static boolean isValidEmail(String email) {
    return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
  }

  public static boolean isNumeric(String str) {
    return str.matches("\\d+");
  }

  public static boolean isPhoneNumber(String phone) {
    return phone.matches("\\+?\\d{10,13}");
  }
}
