@Service
public class UserJobInteractionService {
    private final UserJobInteractionRepository interactionRepository;

    public UserJobInteractionService(UserJobInteractionRepository interactionRepository) {
        this.interactionRepository = interactionRepository;
    }

    public void saveInteraction(String userId, String jobId, String interactionType) {
        UserJobInteraction interaction = new UserJobInteraction(userId, jobId, interactionType);
        interactionRepository.save(interaction);
    }

    public List<String> getAppliedJobIds(String userId) {
        return interactionRepository.findByUserIdAndInteractionType(userId, "APPLIED")
                .stream()
                .map(UserJobInteraction::getJobId)
                .collect(Collectors.toList());
    }
}
