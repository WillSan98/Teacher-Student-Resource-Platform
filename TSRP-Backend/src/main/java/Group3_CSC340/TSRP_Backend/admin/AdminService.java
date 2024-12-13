package Group3_CSC340.TSRP_Backend.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public User loginUser(String email, String password) {
        return adminRepository.findByEmailAndPassword(email, password);
    }

    public List<User> getActiveUsers() {
        return adminRepository.findByBanStatusFalse();
    }

    public List<User> getBannedUsers() {
        return adminRepository.findByBanStatusTrue();
    }

    public void banUser(int userId) {
        User user = adminRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setBanStatus(true);
            adminRepository.save(user);
        }
    }

    public void unBanUser(int userId) {
        User user = adminRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setBanStatus(false);
            adminRepository.save(user);
        }
    }

    public User getUserById(int userId) {
        return adminRepository.findById(userId).orElse(null);
    }

    public void saveUser(User user){
        adminRepository.save(user);
    }

    public void deleteUserById(int userId) {
        adminRepository.deleteById(userId);
    }
}
