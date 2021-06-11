### 1단계

1. 미션 시작
- next-step/mission 에 나의 브랜치가 생긴다.

2. fork
- next-step/mission 에서 작업 불가능
- fork 하면 next-step/mission 저장소가 내 계정에 복제된다.
- lee-yerim/mission 에서 작업 가능

3. clone
- 원격 저장소 lee-yerim/mission 을 로컬 저장소 내 pc 에 복제한다.
  (복제하며 내 이름의 브랜치를 생성한다.)
  
4. checkout
- 기능 구현할 별도의 step1 브랜치를 생성한다.

5. intellij
- 로컬 저장소 step1 브랜치에서 기능 구현

6. add, commit
- 로컬 저장소 step1 브랜치에서 구현한 기능을 로컬 저장소 lee-yerim 브랜치에 반영

7. push
- 로컬 저장소에서 구현한 기능을 원격 저장소에 step1 브랜치를 만들어서 반영

### 2단계

1. pull request
- 원격 저장소 lee-yerim/mission의 step1 브랜치에서 원격 저장소 next-step/mission 의 lee-yerim 브랜치로 코드리뷰요청한다. 
- pull request 는 처음 한 번만 한다.
- 이후에는 add, commit, push 를 반복하여 미션을 진행한다.

2. merge


### 3단계

1. 
- 로컬저장소의 step1 브랜치 삭제

2. remote add upstream 동기화
- 내 로컬 저장소는 현재 최신 버전이 아니다.
- merge 한 next-step/mission 저장소와 내 로컬 저장소를 동기화
- 처음 한 번만 실행
- 이제 내 로컬 저장소에서 원격 저장소 next-step/mission 에 접근할 수 있다.

3. fetch upstream 
- 동기화된 원격 저장소 next-step/mission 에 접근하여 내 브랜치를 가져온다.
- 내 로컬 저장소에 upstream/lee-yerim 브랜치가 생성된다.

4. rebase


5. checkout
- 기능 구현할 별도의 step2 브랜치를 생성한다.
- add, commit, push
- 리뷰 요청 pull request
- 리뷰 반영 add, commit, push 반복
- 마지막 merge