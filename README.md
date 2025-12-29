# 🏝️ Island+

**1.5가구를 위한 스마트 라이프 플랫폼**

> "모두가 섬인 시대, 각자의 섬을 더 견고하게 가꾸는 동시에 필요할 때 언제든 건너갈 수 있는 유연하고 안전한 다리를 건설합니다."

## 📱 프로젝트 개요

Island+는 혼자 살지만 완전히 고립되지 않은 삶을 추구하는 **1.5가구**를 위한 종합 라이프스타일 앱입니다.

## 🎯 주요 모듈

### 모듈 A: Smart Island Management (공간 및 자원 관리)
- 외부 창고 디지털 트윈
- 1.5 전용 팬트리 매니저
- 에너지 & 주거 비용 대시보드

### 모듈 B: Life Restoration & HQ (생활 복원 및 건강 지능)
- 최소 단위 조리법 (Pixel Recipe)
- HQ (Health Intelligence) 트래커
- 정서 건강 '마음 거울'

### 모듈 C: Pixel Community & Guardian (자율적 연대)
- Pixel Meetup (목적형 단기 만남)
- 디지털 우정혼 / 법적 가디언 설정
- 펫 & 플랜트 패밀리 케어

### 모듈 D: Modular Life Commerce (커머스 및 서비스)
- 재활용 가능한 모듈러 가구 렌탈
- 1.5가구 맞춤형 보험

## 🛠️ 기술 스택

### Android
- **언어**: Kotlin
- **UI**: Jetpack Compose
- **아키텍처**: MVVM + Clean Architecture
- **DI**: Hilt
- **네트워크**: Retrofit + OkHttp
- **Navigation**: Navigation Compose

### iOS (예정)
- **언어**: Swift
- **UI**: SwiftUI
- **아키텍처**: MVVM

## 📁 프로젝트 구조

```
island/
├── android/           # Android 네이티브 앱
│   └── app/
│       └── src/main/
│           ├── java/com/island/app/
│           │   ├── ui/           # UI 레이어
│           │   ├── data/         # 데이터 레이어
│           │   └── util/         # 유틸리티
│           └── res/              # 리소스
├── ios/               # iOS 네이티브 앱 (예정)
└── backend/           # 백엔드 서버 (예정)
```

## 🚀 시작하기

### Android

1. Android Studio를 설치합니다
2. 프로젝트를 클론합니다:
   ```bash
   git clone https://github.com/beyondReal-smap/island.git
   ```
3. Android Studio에서 `android` 폴더를 엽니다
4. Gradle sync가 완료되면 실행합니다

## 📄 라이선스

Copyright © 2024 Island+ Team. All rights reserved.
