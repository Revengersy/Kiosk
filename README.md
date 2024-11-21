# 🍔 프로젝트: Java Kiosk Application

## 📋 소개

이 프로젝트는 Java로 구현된 간단한 키오스크 애플리케이션입니다. 사용자가 메뉴를 선택하고 세부 정보를 확인할 수 있는 시스템을 제공합니다. 해당 애플리케이션은 여러 레벨의 복잡도를 통해 단계적으로 확장됩니다.

## 🗂 구조

- **Lv1:** 기본적인 콘솔 기반 메뉴 시스템 구현
- **Lv2:** `MenuItem` 클래스를 통해 메뉴 항목의 객체 지향적 처리 도입
- **Lv3:** 키오스크 시스템을 모듈화하고, 메뉴 항목의 유연한 관리를 구현
- **Lv4:** 다양한 종류의 메뉴와 세부 항목을 관리할 수 있는 확장된 키오스크 시스템

## 🧩 클래스 설명

### Lv1

- **`Main` 클래스**  
  - 콘솔 입력을 통해 메뉴 선택 기능을 제공합니다.
  - 메뉴는 배열로 관리되며, 사용자가 선택하면 설명을 출력합니다.

### Lv2

- **`Main` 클래스**  
  - `MenuItem` 객체를 사용하여 메뉴 항목을 관리합니다.
  - 생성자 체이닝을 활용하여 `MenuItem`의 다양한 초기화 방법을 제공합니다.

- **`MenuItem` 클래스**  
  - 메뉴 항목의 이름, 가격, 설명을 저장합니다.
  - 여러 생성자를 통해 다양한 초기화 방법을 제공합니다.

### Lv3

- **`Kiosk` 클래스**  
  - `MenuItem` 리스트로 메뉴를 관리하며, 사용자 입력을 통해 메뉴를 탐색할 수 있도록 합니다.

### Lv4

- **`Main` 클래스**  
  - 여러 종류의 메뉴를 추가하고 `Kiosk`를 통해 시작합니다.

- **`Kiosk` 클래스**  
  - 여러 `Menu` 객체를 관리하며, 사용자 입력을 통해 세부 메뉴 항목까지 탐색할 수 있도록 합니다.

- **`Menu` 클래스**  
  - 메뉴 카테고리와 세부 항목을 관리합니다.

- **`MenuItem` 클래스**  
  - 메뉴 항목의 세부 정보를 저장하고, 출력 메서드를 제공합니다.

## 🔧 기능

- 메뉴 탐색 및 선택 기능
- 각 메뉴 항목의 세부 정보 출력
- 객체 지향적인 메뉴 관리 시스템

## 📝 사용 방법

1. 애플리케이션을 실행하십시오.
2. 콘솔에 표시되는 메뉴 번호를 입력하여 메뉴 항목을 탐색하십시오.
3. 0번을 입력하면 프로그램이 종료됩니다.

## ⚙️ 요구 사항

- Java Development Kit (JDK) 8 이상
