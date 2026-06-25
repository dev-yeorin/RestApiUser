package com.example.restapiuser.Service;

import com.example.restapiuser.dto.UserResponse;
import com.example.restapiuser.entity.UserEntity;
import com.example.restapiuser.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // UserEntity( table ) -> UserResponse ( 화면 출력 )
    public List<UserResponse> findUsers(String keyword) {
        List<UserEntity> users;
        if(keyword == null || keyword.isEmpty()){
            // 검색어가 없을 때
            users = userRepository.findAllByOrderByIndateAsc( );
        } else {
            // 검색어가 있을 때
            users = userRepository.
                    findByUseridContainingIgnoreCaseOrderByIndateAsc(keyword.trim());
        }
        return users.stream()
                .map(UserResponse::from) // 모든 요소에 함수를 적용해서 새로운 stream 생성 (.map())
                .toList();
                // list.stream() -> ArrayList 변경
    }
}
