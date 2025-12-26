@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SkillGapRecommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double gapScore;

    @Builder.Default
    private Instant generatedAt = Instant.now();

    private String generatedBy;

    @ManyToOne
    private StudentProfile studentProfile;

    @ManyToOne
    private Skill skill;
}
