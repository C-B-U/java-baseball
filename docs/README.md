## 기능 명세
1. 랜덤 정답 생성 기능
    - 정답 저장 기능
2. 사용자 정답 입력 기능
    - input 숫자 여부 검증 및 예외처리
    - input 숫자의 길이 검증 및 예외처리
3. Strike와 Ball 개수 판단 기능
   - 3 Strike인 경우 게임 종료 기능
   - 3 Strike가 아닌 경우 결과 출력 기능
4. 정답인 경우 새 게임 진행 여부 입력 기능
   - input 1 or 2 검증 및 예외처리
   - input 1인 경우 새 게임 시작 기능
   - input 0인 경우 종료 기능

## 구현 클래스 명세

### Application - 실행을 담당
- (main) 어플리케이션의 실행

### BaseballController - 정답 관련 요청과 입력 검증을 담당
- (startGame) 하나의 게임 실행
- (validateUserAttempt) 유저의 시도 마다 입력값 검증

### BaseballService - 정답 관련 서비스 로직 담당
- (saveAnswer) 정답을 생성하여 저장

### BaseballRepository - 정답 정보 저장, 조회를 담당
- (saveAnswer) 정답 저장

### Answer - 정답 정보를 가진 불변클래스
- (generateRandomNumbers) 랜덤한 숫자를 생성
- (createAnswer) 불변클래스의 팩토리 메서드

### ComponentFactory - 컴포넌트들의 생성을 담당
- (baseballController) baseballController 생성
- (baseballService) baseballService 생성
- (baseballRepository) baseballRepository 생성
- (userAttemptValidator) userAttemptValidator 생성

### UserAttemptValidator - 유저의 시도에 대한 입력값 검증
- (validate) 유저의 시도에 대한 입력값 검증
- (notValidString) 입력 String 이 유효한지 검증

## 구현 열거형 명세

### GameMessage
- 게임의 메시지들을 나타낸다.

### RandomNumberRange
- 랜덤한 숫자의 범위, 자릿수를 나타낸다.
