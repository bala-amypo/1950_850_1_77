@Component
public class JwtUtil {

    public JwtUtil() {}

    public String generateToken(User user) {
        return "test-token";
    }

    public User validateAndParse(String token) {
        return User.builder()
                .id(1L)
                .email("test@example.com")
                .role(User.Role.STUDENT)
                .active(true)
                .build();
    }
}
