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

data class LoginState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isPasswordVisible: Boolean = false,
    val emailError: String? = null,
    val passwordError: String? = null,
    val generalError: String? = null,
    val isLoginSuccess: Boolean = false
)

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    
    var state by mutableStateOf(LoginState())
        private set
    
    fun onEmailChange(email: String) {
        state = state.copy(email = email, emailError = null, generalError = null)
    }
    
    fun onPasswordChange(password: String) {
        state = state.copy(password = password, passwordError = null, generalError = null)
    }
    
    fun togglePasswordVisibility() {
        state = state.copy(isPasswordVisible = !state.isPasswordVisible)
    }
    
    fun onLogin() {
        if (!validateInput()) return
        
        viewModelScope.launch {
            state = state.copy(isLoading = true, generalError = null)
            
            try {
                // TODO: Implement actual API call
                delay(1500) // Simulating network request
                
                // Simulate successful login
                state = state.copy(
                    isLoading = false,
                    isLoginSuccess = true
                )
            } catch (e: Exception) {
                state = state.copy(
                    isLoading = false,
                    generalError = "로그인에 실패했습니다. 다시 시도해주세요."
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
        
        return isValid
    }
}
