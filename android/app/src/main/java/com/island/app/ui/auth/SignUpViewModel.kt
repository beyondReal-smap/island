package com.island.app.ui.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SignUpState(
    val email: String = "",
    val password: String = "",
    val passwordConfirm: String = "",
    val nickname: String = "",
    val isLoading: Boolean = false,
    val isPasswordVisible: Boolean = false,
    val isPasswordConfirmVisible: Boolean = false,
    val emailError: String? = null,
    val passwordError: String? = null,
    val passwordConfirmError: String? = null,
    val nicknameError: String? = null,
    val generalError: String? = null,
    val isSignUpSuccess: Boolean = false
)

@HiltViewModel
class SignUpViewModel @Inject constructor() : ViewModel() {
    
    var state by mutableStateOf(SignUpState())
        private set
    
    fun onEmailChange(email: String) {
        state = state.copy(email = email, emailError = null)
    }
    
    fun onPasswordChange(password: String) {
        state = state.copy(password = password, passwordError = null)
    }
    
    fun onPasswordConfirmChange(passwordConfirm: String) {
        state = state.copy(passwordConfirm = passwordConfirm, passwordConfirmError = null)
    }
    
    fun onNicknameChange(nickname: String) {
        state = state.copy(nickname = nickname, nicknameError = null)
    }
    
    fun togglePasswordVisibility() {
        state = state.copy(isPasswordVisible = !state.isPasswordVisible)
    }
    
    fun togglePasswordConfirmVisibility() {
        state = state.copy(isPasswordConfirmVisible = !state.isPasswordConfirmVisible)
    }
    
    fun onSignUp() {
        if (!validateInput()) return
        
        viewModelScope.launch {
            state = state.copy(isLoading = true, generalError = null)
            
            try {
                // TODO: Implement actual API call
                delay(2000) // Simulating network request
                
                state = state.copy(
                    isLoading = false,
                    isSignUpSuccess = true
                )
            } catch (e: Exception) {
                state = state.copy(
                    isLoading = false,
                    generalError = "회원가입에 실패했습니다. 다시 시도해주세요."
                )
            }
        }
    }
    
    private fun validateInput(): Boolean {
        var isValid = true
        
        // Email validation
        if (state.email.isBlank()) {
            state = state.copy(emailError = "이메일을 입력해주세요")
            isValid = false
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(state.email).matches()) {
            state = state.copy(emailError = "올바른 이메일 형식이 아닙니다")
            isValid = false
        }
        
        // Password validation
        if (state.password.isBlank()) {
            state = state.copy(passwordError = "비밀번호를 입력해주세요")
            isValid = false
        } else if (state.password.length < 8) {
            state = state.copy(passwordError = "비밀번호는 8자 이상이어야 합니다")
            isValid = false
        }
        
        // Password confirm validation
        if (state.passwordConfirm.isBlank()) {
            state = state.copy(passwordConfirmError = "비밀번호 확인을 입력해주세요")
            isValid = false
        } else if (state.password != state.passwordConfirm) {
            state = state.copy(passwordConfirmError = "비밀번호가 일치하지 않습니다")
            isValid = false
        }
        
        // Nickname validation
        if (state.nickname.isBlank()) {
            state = state.copy(nicknameError = "닉네임을 입력해주세요")
            isValid = false
        } else if (state.nickname.length < 2) {
            state = state.copy(nicknameError = "닉네임은 2자 이상이어야 합니다")
            isValid = false
        }
        
        return isValid
    }
}
