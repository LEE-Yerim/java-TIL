문서 제목
========

문서 부제목
---------

#글머리1
##글머리2
###글머리3
####글머리4
#####글머리5
######글머리6

> 첫번째 BlockQuote
> > 두번쨰 BlockQuote
> > > 세번째 BlockQuote

1. 순서 있는 목록
2. 순서 있는 목록
3. 순서 있는 목록

- 순서 없는 목록
  - 순서 없는 목록
    - 순서 없는 목록
      - 순서 없는 목록
        - 순서 없는 목록

+ 순서 없는 목록
  * 순서 없는 목록
    
This is a normal paragraph:

    This is a code block.

end code block.

This is a normal paragraph:
    This is a code block.
end code block.

<pre>
<code>
public class Example {
    public static void main(String[] args) {
    System.out.println("markdown-example");
    }
}
</code></pre>
```
public class Example {
    public static void main(String[] args) {
    System.out.println("markdown-example");
    }
}
```
```java
public class Example {
    public static void main(String[] args) {
        System.out.println("markdown-example");
    }
}
```

* * *
***
******
- - -
------
-------

[Google][googlelink]

[googlelink]: https://google.com "Go google"

[Google](https://google.com, "google link")

<http://example.com/>
<address@naver.com>

## 상대경로란?
상대경로란 현재 파일을 기준으로 상위 폴더와 하위 폴더, 혹은 현재 폴더를 찾아 다른 파일과 연결해주는 주소를 뜻합니다.

## 상대경로 지정하는 방법
- / : 루트(최상위 폴더)
- ./ : 현재 파일과 같은 디렉터리
- ../ : 현재 파일보다 한 단계 위의 디렉터리
```
📂test            
┣ 📂docs
┃ ┣ 📂folderA
┃ ┃ ┗ a.md            
┃ ┣ 📂folderB
┃ ┃ ┗ b.md             
┃ ┣ docs.md
┃ ┗ index.md
┗ README.md
```
- README.md 파일에서 b.md 파일로 이동하려면
  - ./docs/folderB/b.md
- b.md 파일에서 README.md 파일로 이동하려면
  - ../../README.md



참고자료
- []()
- [상대경로](https://velog.io/@dblee/%EA%B9%83%ED%97%88%EB%B8%8CMarkdown-%EC%82%AC%EC%9A%A9%EB%B2%95-%EB%A7%81%ED%81%AC-%EA%B1%B8%EA%B8%B0)
