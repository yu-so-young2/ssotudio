# ssotudio
어플 스튜디오를 사용할 수 없는 환경에서도 쓸 수 있는 기능들 모음(API가 아직 안나왔거나, company배포가 아직 안됐거나, 스튜디오 접근이 어려울 때)
업무 자동화를 통한 효율성 극대화를 실현해보자!!

### 세부 기능
- **테이블 생성기 `done`**
    - response를 넣으면 그에 맞는 테이블 기본 columns를 응답으로 내려줍니다
- **뱃지 생성기 `done`**
    - key + 뱃지 색상/조건/라벨 리스트를 넣으면 그에 맞는 뱃지 content를 응답으로 내려줍니다
- **폼필드 생성기 `done`**
    - 1) 지원하는 폼필드 목록을 보여줍니다
    - 2) 요청한 폼필드의 기본 포맷 json을 응답으로 내려줍니다
- **테이블 청소기 `done`**
    - order ↔ columns 일치시키기
    - 1) order에서 사용하지 않는 column을 삭제합니다
    - 2) order에만 있고 columns에는 없는 컬럼을 생성합니다(테이블 생성기와 같은 기능)
- **버튼 생성기 `done`**
    - 버튼 라벨 + 타겟 컨테이너 codeName, params 리스트 입력 → 버튼 content를 응답으로 내려줍니다

</br>

### 아키텍처
<img width="1158" alt="아키텍처" src="https://github.com/yu-so-young2/ssotudio/assets/117627859/e3d5b619-19ff-4677-8640-fcad457e0534">

</br>
</br>
</br>