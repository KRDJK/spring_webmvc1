# ??? ?? ??

    # change port number
    server.port=8181

    # view resolver setting (???, ??? ??)
    spring.mvc.view.prefix=/WEB-INF/views/
    spring.mvc.view.suffix=.jsp

    # log level setting
    logging.level.root=info


    # 이렇게 쓰면 com.spring.webmvc.springmvc.chap03의 하위 패키지에서는 로그 레벨이 trace가 된다.
    logging.level.com.spring.webmvc.springmvc.chap03=trace