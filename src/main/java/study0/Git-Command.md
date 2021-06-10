### push 되돌리기
1. 워킹 디렉터리에서 commit 을 되돌린다.
- 가장 최근의 commit을 취소하고 워킹 디렉터리를 되돌린다.
    ```
    // (기본 옵션: --mixed)
    $ git reset HEAD^
    ```
- 원하는 시점으로 워킹 디렉터리를 되돌린다.
    ```
    git reset [commit id]
    ```
2. 되돌려진 상태에서 다시 commit 을 한다.
```
git commit -m "commit message"
```
3. 원격 저장소에 강제로 push 한다.
```
git push -f origin master
```