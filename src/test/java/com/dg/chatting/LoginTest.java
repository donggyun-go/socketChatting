 package com.dg.chatting;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dg.chatting.dto.UserDto;
import com.dg.chatting.repository.LoginDao;
import com.dg.chatting.service.LoginService;
import com.dg.chatting.service.impl.LoginServiceImpl;

@ExtendWith(MockitoExtension.class)
class LoginTest {

    @Mock
    private LoginDao loginDao;

    @InjectMocks
    private LoginService loginService = new LoginServiceImpl();

    @BeforeEach
    void setUp() {
        // 여기서 필요한 설정을 초기화합니다.
    }

    @Test
    void testValidLogin() {
        // 성공적인 로그인 시나리오
        UserDto validUser = new UserDto();
        validUser.setUserId("user1");
        validUser.setUserPass("pass1");
        when(loginDao.getUserById("user1")).thenReturn(validUser);

        boolean result = loginService.validateUser("user1", "pass1");
        assertTrue(result, "The login should be successful.");
    }

    @Test
    void testInvalidLogin() {
        // 실패하는 로그인 시나리오
        when(loginDao.getUserById("user2")).thenReturn(null);

        boolean result = loginService.validateUser("user2", "wrongpass");
        assertFalse(result, "The login should fail due to incorrect user ID or password.");
    }
}