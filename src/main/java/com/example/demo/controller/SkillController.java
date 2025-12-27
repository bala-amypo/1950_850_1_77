@RequiredArgsConstructor
@RestController
@RequestMapping("/skills")
public class SkillController {

    private final SkillService skillService; // now injected correctly
}
