# PortFolioKun
証券口座の保有資産を可視化するサイト <br>
証券会社(SBI,楽天証券)や口座区分(NISA,特定口座)に囚われず、保有する銘柄別で資産を可視化　<br>


https://github.com/kaneko871/PortFolioKun/assets/16371917/7b6b5751-eaf3-4d6d-acc7-8ac95476a7ad


### サイト開発に至った背景
普段私が投資をしてるとき、各証券会社のサイトで保有資産を閲覧するときに下の課題感があり、それを解消するために作成した<br>

- 課題感
    - 各証券会社の保有資産はそれぞれのサイトで確認する必要がある。
    - 同じ証券会社の口座でも口座区分(NISA, 特定)で銘柄が分かれて表示される。
    - 円グラフで表示されないため、資産における各銘柄の資産が視覚的に分かりづらい。

<img width="954" alt="ex" src="https://github.com/kaneko871/PortFolioKun/assets/16371917/ac1c59a3-d4b3-406b-b689-5ae4b8de1626">


# 利用技術
- Java
- Spring Boot, Spring Security, Spring Test
- MyBatis
- PostgreSQL
- Tymeleaf, BootStrap, Chart.js
- Docker, Docker-compose

# 補足
保有資産の登録と削除に関しての補足。<br>
このサイトには、保有資産を登録/削除する機能等も存在するが、<br>
別に各証券会社の保有資産を確認するサイトからスクレイピングした情報をDBに保存するスクリプトを用意していて、それを定期実行してる。<br>
(ただしそのスクリプトは、このリポジトリには存在しておらず、そもそもpublicで公開してない。)
