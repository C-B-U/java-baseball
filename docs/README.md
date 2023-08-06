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
- main() 어플리케이션의 실행

### BaseballController - 정답 관련 요청과 입력 검증을 담당
- startGame() 하나의 게임 실행
- askIsContinue() 게임 종료시 이어서 할 지에 대한 여부 검증
- playGame() 게임 메인 로직 실행
- getUserAttempt() 유저의 정답 시도 입력
- getResult() 결과 계산 로직 실행

### BaseballService - 정답 관련 서비스 로직 담당
- saveAnswer() 정답을 생성하여 저장
- calculateResult() 결과를 계산
- findCurrentAnswer() 현재 정답 정보를 조회

### BaseballRepository - 정답 정보 저장, 조회를 담당
- saveAnswer() 정답 저장
- findCurrentAnswer() 현재 정답 정보를 조회

### Answer - 정답 정보를 가진 불변클래스
- generateRandomNumbers() 랜덤한 숫자를 생성
- createAnswer() 불변클래스의 팩토리 메서드
- hasNum() 매개변수로 받는 숫자가 정답에 포함됐는지 확인

### ComponentFactory - 컴포넌트들의 생성을 담당
- 각 컴포넌트들을 생성

### InputValidator - 유저의 시도에 대한 입력값 검증
- validateUserAttempt() 유저의 시도에 대한 입력값 검증
- notValidAttemptString() 입력 String 이 유효한지 검증
- hasDuplicate() 중복된 숫자가 입력되었는지 검증
- validateIsContinue() 계속 진행할지 여부에 대한 입력 검증
- notValidContinueString() 계속 진행할지 여부에 대한 입력값 검증

### InputReader - 사용자의 입력값 받아와 검증
- readUserAttempt() 유저의 시도 입력 받기 및 입력값 검증
- readIsContinue() 게임 이어서 하기 여부 입력 받기 및 입력값 검증

### OutputWriter - 문자열 출력
- write() 문자열을 그대로 출력
- writeWithLine() 맨 끝에 개행문자와 함께 출력

### ResultProvider - Answer 객체와 유저의 입력을 받아 결과를 반환
- calculateResult() 최종 출력할 결과를 반환
- mapToStrikeBalls() StrikeBall의 리스트로 변환
- checkStrikeBall() 계산을 통해 StrikeBall 하나로 변환 및 반환
- checkBallOrNone() 같은 인덱스에 같은 값이 없는 경우 ball 인지 판단
- findAnswerNumByIndex() 정답 숫자에서 인덱스에 해당하는 숫자 반환
- convertToIntWithIndex() String 에서 인덱스에 해당하는 숫자를 int 로 변환

### ResultOutputFormatter - 출력할 결과 포맷을 만듦
- writeWithLine() 개행문자화 함께 출력
- write() 문자열 그대로 출력
- writeWithFormat() 결과 형태로 변환하여 출력

### Result - strike 개수롸 ball 개수를 갖는 dto
- getStrikeNum() strike 개수 반환
- getBallNum() ball 개수 반환

### ResultOutputFormatter - Result를 결과 문자열로 변환
- format() 결과 문자열로 변환
- getFormattedOutput() format 진행
- toCountResult() strike 혹은 ball 이 있을 경우 변환 진행
- appendStrikeIfExists() strike의 개수에 따라 분기하여 변환

## 구현 열거형 명세

### GameMessage
- 게임의 메시지들을 나타낸다.

### RandomNumberRange
- 랜덤한 숫자의 범위, 자릿수를 나타낸다.

### StrikeBall
- 스트라이크, 볼을 나타낸다.

### ResultMessage
- 결과 메시지를 나타낸다.
