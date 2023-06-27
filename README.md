# 서울시 공공 와이파이 정보 구하기
> Model1 구조입니다.

## 📄 개요
- 이 프로젝트는 사용자의 위치 기반으로 주변에 있는 서울시 공공 와이파이 정보를 제공하는 웹 서비스입니다.
- 사용자는 입력한 위치 좌표를 기반으로 주변에 있는 공공 와이파이 정보를 확인할 수 있습니다.
- 조회한 좌표 정보는 데이터베이스에 저장하여 나중에도 확인할 수 있습니다.
- 또한, 북마크 그룹을 생성하고 와이파이 정보를 북마크로 추가하거나 삭제할 수 있습니다.

## 📌 기능 사항
1. OPEN API를 활용하여 서울시의 모든 공공 와이파이 정보를 가져옵니다.
2. 사용자가 입력한 위치 좌표를 기반으로 주변에 있는 공공 와이파이 정보 20개를 보여줍니다.
3. 사용자가 입력한 위치 정보와 조회한 시점을 기준으로 DB에 정보를 저장하고, 저장된 정보를 조회할 수 있습니다.
4. 특정 공공 와이파이의 상세 정보를 제공합니다.
5. 사용자는 북마크 그룹을 생성하고, 그룹 목록을 확인하며 그룹을 수정하거나 삭제할 수 있습니다.
6. 사용자는 공공 와이파이 정보를 북마크로 추가하거나 삭제할 수 있습니다.

## 📚 기술 스택
- 개발 언어: Java (JDK 1.8), JSP
- 라이브러리: gson 2.9.0, lombok 1.18.24, sqlite 3.36.03
- 개발 도구: IntelliJ IDEA, GitHub, eXERD

## 📅 개발 기간
- 2023/06/19 ~ 2023/07/10

## ERD
<img width="985" alt="스크린샷 2023-06-27 오후 6 45 30" src="https://github.com/9898s/seoul-public-wifi/assets/46531692/52372f95-8585-4cb2-8d57-de0a5b79c66c">

## 시연 영상