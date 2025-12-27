@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssessmentResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assessmentId;
    private double score;
    private Instant attemptedAt;

    @ManyToOne
    private StudentProfile studentProfile;

    @ManyToOne
    private Skill skill;
}
