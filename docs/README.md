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

### CountProvider - 스트림에서 스트라이크, 볼의 개수를 세는 함수형 인터페이스
- (countOf) Stream<BallCount> 를 받아 Integer 를 반환

### ResultProvider - Answer 객체와 유저의 입력을 받아 결과를 반환
- (getResult) 최종 출력할 결과를 반환
- (countOfStrikeBall) 스트라이크, 볼의 개수를 계산
- (getStrikeBallStream) 입력값을 StrikeBall 으로 변환한 스트림을 반환
- (matches) 입력값 한 자리를 인덱스와 함께 비교해 strike, ball 여부를 판단
- (checkBallOrNone) 같은 인덱스에 같은 값이 없는 경우 ball 인지 판단
- (findAnswerNumByIndex) 정답 숫자에서 인덱스에 해당하는 숫자 반환
- (convertToIntWithIndex) String 에서 인덱스에 해당하는 숫자를 int 로 변환

## 구현 열거형 명세

### GameMessage
- 게임의 메시지들을 나타낸다.

### RandomNumberRange
- 랜덤한 숫자의 범위, 자릿수를 나타낸다.

### StrikeBall
- 스트라이크, 볼을 나타낸다.

### BallCount
- 스트라이크, 볼의 개수에 따른 볼카운트를 계산한다.
- 상황에 맞는 메시지를 갖는다.
