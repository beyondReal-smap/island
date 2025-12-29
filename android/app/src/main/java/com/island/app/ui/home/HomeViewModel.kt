package com.island.app.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class HomeState(
    val userName: String = "Island 유저",
    val greeting: String = "",
    val selectedTab: Int = 0
)

data class ModuleItem(
    val id: String,
    val title: String,
    val subtitle: String,
    val icon: String,
    val color: Long
)

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    
    var state by mutableStateOf(HomeState())
        private set
    
    val modules = listOf(
        ModuleItem(
            id = "smart_island",
            title = "Smart Island",
            subtitle = "공간 및 자원 관리",
            icon = "🏠",
            color = 0xFF1ABC9C
        ),
        ModuleItem(
            id = "life_restoration",
            title = "Life & HQ",
            subtitle = "생활 복원 및 건강",
            icon = "🍳",
            color = 0xFFFF7675
        ),
        ModuleItem(
            id = "pixel_community",
            title = "Pixel Community",
            subtitle = "자율적 연대",
            icon = "👥",
            color = 0xFFA29BFE
        ),
        ModuleItem(
            id = "modular_commerce",
            title = "Life Commerce",
            subtitle = "맞춤형 커머스",
            icon = "🛒",
            color = 0xFFFFEAA7
        )
    )
    
    val quickActions = listOf(
        ModuleItem(
            id = "pantry",
            title = "팬트리",
            subtitle = "소모품 관리",
            icon = "📦",
            color = 0xFF74B9FF
        ),
        ModuleItem(
            id = "recipe",
            title = "레시피",
            subtitle = "오늘의 요리",
            icon = "🥗",
            color = 0xFF55EFC4
        ),
        ModuleItem(
            id = "meetup",
            title = "밋업",
            subtitle = "오늘의 만남",
            icon = "☕",
            color = 0xFFFD79A8
        ),
        ModuleItem(
            id = "health",
            title = "건강",
            subtitle = "HQ 트래커",
            icon = "❤️",
            color = 0xFFE17055
        )
    )
    
    init {
        updateGreeting()
    }
    
    private fun updateGreeting() {
        val hour = java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY)
        val greeting = when (hour) {
            in 5..11 -> "좋은 아침이에요"
            in 12..17 -> "좋은 오후예요"
            in 18..21 -> "좋은 저녁이에요"
            else -> "편안한 밤이에요"
        }
        state = state.copy(greeting = greeting)
    }
    
    fun onTabSelected(index: Int) {
        state = state.copy(selectedTab = index)
    }
}
