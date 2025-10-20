# 🧮 문자열 덧셈 계산기 (java-calculator-precourse)

문자열을 입력받아 정해진 구분자를 기준으로 숫자를 분리한 뒤,  
그 합을 계산해 출력하는 **문자열 덧셈 계산기**입니다.

---

## 📌 프로그램 동작 규칙

- 입력한 문자열에서 숫자를 추출하여 **모두 더한 결과**를 반환합니다.
- 기본 구분자는 **쉼표( , )** 또는 **콜론( : )**입니다.  
  예시:
  ```
  ""           => 0  
  "1,2"        => 3  
  "1,2,3"      => 6  
  "1,2:3"      => 6
  ```

- 커스텀 구분자도 사용할 수 있습니다.  
  문자열의 시작 부분에 `"//"`와 `"\n"` 사이에 있는 문자를 커스텀 구분자로 인식합니다.

  예시:
  ```
  "//;\n1;2;3" => 6  (구분자 ; 를 사용)
  "//.\n2.3.4" => 9
  ```

- 입력이 비어 있거나 null이면 **0을 반환**합니다.

- 음수나 숫자가 아닌 값을 입력하면  
  **IllegalArgumentException 예외를 발생시키고 프로그램은 종료**되어야 합니다.

---

## ✅ 커밋 규칙

- 모든 커밋은 **기능 단위로 분리**하여 작성합니다.
- 커밋 메시지는 [AngularJS Git Commit Message Convention](https://github.com/angular/angular.js/blob/master/DEVELOPERS.md#commits)을 따릅니다.

### 📋 Allowed `<type>`
- `feat`: 새로운 기능 추가
- `fix`: 버그 수정
- `docs`: 문서 수정
- `style`: 코드 포맷팅, 세미콜론 등
- `refactor`: 코드 리팩토링
- `test`: 테스트 코드 작성 또는 수정
- `chore`: 빌드 설정, 기타 유지보수

### ✍️ 커밋 메시지 예시
```
feat(parser): add support for custom delimiter

fix(calculator): handle empty input case

docs(readme): explain program rules and commit convention
```
